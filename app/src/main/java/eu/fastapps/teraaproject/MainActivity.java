package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int defaultValue;
    boolean recordingValue;
    boolean natureSoundsValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!hasSavedPreferences()){
            Intent intent = new Intent(this, IntroActivity.class);
            startActivity(intent);
        }

        findViewById(R.id.button_settings).setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                }
        );

        findViewById(R.id.button_info).setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(this, InfoActivity.class);
                    startActivity(intent);
                }
        );

        findViewById(R.id.button_help).setOnClickListener(
                (v) -> {
                    loadPreferences();
                    Intent intent;
                    switch(defaultValue){

                        case 1:
                            intent = new Intent(this, TechniqueActivity.class);
                            startActivity(intent);
                            break;

                        case 2:
                            //exercise TODO
                            //intent = new Intent(this, .class);
                            break;

                        default:
                            //game TODO
                            //intent = new Intent(this, .class);
                            break;
                    }



                }
        );


    }

    private boolean hasSavedPreferences(){
        //TODO
        return false;
    }

    private void loadPreferences(){
        SharedPreferences preferences  = getSharedPreferences("Settings", 0);

        defaultValue = preferences.getInt("default", 0);

        recordingValue = preferences.getBoolean
                ("recording", false);

        natureSoundsValue = preferences.getBoolean
                ("nature_sounds", false);

    }
}