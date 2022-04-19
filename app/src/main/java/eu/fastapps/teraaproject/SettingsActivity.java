package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Saving state of our app
        // using SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);

        final Switch enabledarkmode = findViewById(R.id.switch_darkmode);
        // When user reopens the app
        // after applying dark/light mode
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            enabledarkmode.setText("Disable Dark Mode");
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            enabledarkmode.setText("Enable Dark Mode");
        }

        enabledarkmode.setOnClickListener(view -> {
            // When user taps the enable/disable
            // dark mode button
            if (isDarkModeOn) {

                // if dark mode is on it
                // will turn it off
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                // it will set isDarkModeOn
                // boolean to false
                editor.putBoolean("isDarkModeOn", false);
                editor.apply();

                // change text of Button
                enabledarkmode.setText("Enable Dark Mode");
            } else {

                // if dark mode is off
                // it will turn it on
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                // it will set isDarkModeOn
                // boolean to true
                editor.putBoolean("isDarkModeOn", true);
                editor.apply();

                // change text of Button
                enabledarkmode.setText("Disable Dark Mode");
            }
        });


        findViewById(R.id.text_customizehelp).setOnClickListener(
                (v) -> {
                    startActivity(new Intent(this, IntroActivity.class));
                }
        );

    }
}