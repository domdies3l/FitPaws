package master.fitpaws;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import sql.fitpaws.DatabaseHelper;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = ProfileActivity.this;
    private AppCompatEditText name;
    private AppCompatEditText email;
    private DatabaseHelper dbHelper;
    private AppCompatEditText age;
    private AppCompatEditText weight;
    private AppCompatEditText sex;
    private AppCompatEditText breed;
    private AppCompatEditText color;
    private AppCompatButton save;
    private User user;
    private User updatedUser;

    private NestedScrollView profileScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        initObjects();
        initListeners();
    }

    private void initViews() {
        profileScrollView = (NestedScrollView) findViewById(R.id.profileScrollView);
        name = (AppCompatEditText) findViewById(R.id.textInputEditTextName);
        email = (AppCompatEditText) findViewById(R.id.textInputEditTextEmail);
        weight = (AppCompatEditText) findViewById(R.id.textInputEditTextWeight);
        age = (AppCompatEditText) findViewById(R.id.textInputEditTextAge);
        sex = (AppCompatEditText) findViewById(R.id.textInputEditTextSex);
        breed = (AppCompatEditText) findViewById(R.id.textInputEditTextBreed);
        color = (AppCompatEditText) findViewById(R.id.textInputEditTextColor);
        save = (AppCompatButton) findViewById(R.id.saveButton);

    }

    private void initObjects() {
//
        dbHelper = new DatabaseHelper(activity);
        user = dbHelper.getUser(UserContext.getUserId());

        String nameText = user.getName();
        name.setText(nameText);

        String emailText = user.getEmail();
        email.setText(emailText);

        String ageText = user.getAge();
        age.setText(ageText);

        String weightText = user.getWeight();
        weight.setText(weightText);

        String sexText = user.getSex();
        sex.setText(sexText);

        String breedText = user.getBreed();
        breed.setText(breedText);

        String colorText = user.getColor();
        color.setText(colorText);
    }

    private void initListeners() {
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.saveButton:
                updateUser();
                break;
        }
    }

    private void updateUser(){


        user = dbHelper.getUser(UserContext.getUserId());

        String newName = name.getText().toString();
        user.setName(newName);

        String newEmail = email.getText().toString();
        user.setEmail(newEmail);

        String newAge = age.getText().toString();
        user.setAge(newAge);

        String newWeight = weight.getText().toString();
        user.setWeight(newWeight);

        String newSex = sex.getText().toString();
        user.setSex(newSex);

        String newBreed = breed.getText().toString();
        user.setBreed(newBreed);

        String newColor = color.getText().toString();
        user.setColor(newColor);

        dbHelper.updateUser(user);

        Snackbar.make(profileScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();

    }



//        Spinner spinner = (Spinner) findViewById(R.id.textInputEditTextSex);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.sex_selection, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);


}
