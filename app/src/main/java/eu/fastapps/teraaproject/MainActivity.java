package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button_settings).setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                }
        );
    }
}