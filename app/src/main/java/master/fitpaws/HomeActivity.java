package master.fitpaws;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    private final AppCompatActivity activity = HomeActivity.this;
    private AppCompatTextView textViewName;
    private AppCompatImageButton settingsButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        initListeners();
        initObjects();

    }


    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        settingsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        settingsButton = (AppCompatImageButton) findViewById(R.id.settingsButton);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);
    }
}
