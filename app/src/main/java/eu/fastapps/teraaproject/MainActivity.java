package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

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
                    loadPreferences(1);
                    Intent intent = null;
                    switch(defaultValue){
                        case 1:
                            intent = new Intent(this, TechniqueActivity.class);
                            break;

                        case 2:
                            intent = new Intent(this, ExerciceActivity.class);
                            break;

                        default:
                            //game TODO
                            //intent = new Intent(this, .class);
                            break;
                    }

                    if (intent != null) {
                        if(recordingValue){
                            intent.putExtra("sound", 0);
                        }
                        else if(natureSoundsValue)
                        {
                            intent.putExtra("sound", 1);
                        }
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(this, "Option not implemented yet",
                                Toast.LENGTH_SHORT).show();
                    }



                }
        );


    }

    private boolean hasSavedPreferences(){
        loadPreferences(-1);

        return defaultValue != -1;
    }

    private void loadPreferences(int def){
        SharedPreferences preferences  = getSharedPreferences("Settings", 0);

        defaultValue = preferences.getInt("default", def);

        recordingValue = preferences.getBoolean
                ("recording", false);

        natureSoundsValue = preferences.getBoolean
                ("nature_sounds", false);

    }
}
