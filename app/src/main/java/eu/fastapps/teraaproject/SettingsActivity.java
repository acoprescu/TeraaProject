package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.text_customizehelp).setOnClickListener(
                (v) -> {
                    startActivity(new Intent(this, IntroActivity.class));
                }
        );

    }
}