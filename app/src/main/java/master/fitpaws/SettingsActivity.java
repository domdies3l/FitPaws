package master.fitpaws;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {
    private final AppCompatActivity activity = SettingsActivity.this;
    private AppCompatTextView textViewEditProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();
        initListeners();
        initObjects();

    }


    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        textViewEditProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewEditProfile = (AppCompatTextView) findViewById(R.id.textViewEditProfile);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
    }
}
