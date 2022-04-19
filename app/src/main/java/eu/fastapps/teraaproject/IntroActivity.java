package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {


    Button gameButton;
    Button techniqueButton;
    Button exerciseButton;

    Button recordingButton;
    Button natureSoundsButton;

    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        gameButton = findViewById(R.id.button_game);
        gameButton.setOnClickListener(
                (v) -> onGameButton()
        );

        techniqueButton = findViewById(R.id.button_tehnique);
        techniqueButton.setOnClickListener(
                (v) -> onTechnicqueButton()
        );

        exerciseButton = findViewById(R.id.button_exercise);
        exerciseButton.setOnClickListener(
                (v) -> onExerciseButton()
        );

        recordingButton = findViewById(R.id.button_recording);
        recordingButton.setOnClickListener(
                (v) -> onRecordButton()
        );

        natureSoundsButton = findViewById(R.id.button_nature_sounds);
        natureSoundsButton.setOnClickListener(
                (v) -> onNatureSoundButton()
        );

        saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(
                (v) -> onSaveButton()
        );

        loadPreferences();

    }

    private void onGameButton() {
        gameButton.setSelected(true);
        techniqueButton.setSelected(false);
        exerciseButton.setSelected(false);
    }



    private void onTechnicqueButton() {
        gameButton.setSelected(false);
        techniqueButton.setSelected(true);
        exerciseButton.setSelected(false);
    }

    private void onExerciseButton() {
        gameButton.setSelected(false);
        techniqueButton.setSelected(false);
        exerciseButton.setSelected(true);
    }

    void onRecordButton(){
        if(recordingButton.isSelected()){
            recordingButton.setSelected(false);
        }
        else{
          recordingButton.setSelected(true);
          natureSoundsButton.setSelected(false);
        }

    }


    private void onNatureSoundButton() {
        if(natureSoundsButton.isSelected()){
            natureSoundsButton.setSelected(false);
        }
        else{
            natureSoundsButton.setSelected(true);
            recordingButton.setSelected(false);
        }
    }

    private void onSaveButton(){
        savePreferences();
        finish();
    }

    private void savePreferences(){
        SharedPreferences preferences  = getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor  = preferences.edit();

        int defaultOption = -1;

        if(gameButton.isSelected()){
            defaultOption = 0;
        }
        else if(techniqueButton.isSelected()){
            defaultOption = 1;
        }
        else if(exerciseButton.isSelected()){
            defaultOption = 2;
        }

        editor.putInt("default", defaultOption);

        if(recordingButton.isSelected()){
            editor.putBoolean("recording", true);
        }
        else{
            editor.putBoolean("recording", false);
        }

        if(natureSoundsButton.isSelected()){
            editor.putBoolean("nature_sounds", true);
        }
        else{
            editor.putBoolean("nature_sounds", false);
        }

        editor.apply();

    }

    private void loadPreferences(){
        SharedPreferences preferences  = getSharedPreferences("Settings", 0);

        int defaultValue = preferences.getInt("default", 0);

        gameButton.setSelected(defaultValue == 0);
        techniqueButton.setSelected(defaultValue == 1);
        exerciseButton.setSelected(defaultValue == 2);

        boolean recordingValue = preferences.getBoolean
                ("recording", false);
        recordingButton.setSelected(recordingValue);

        boolean natureSoundsValue = preferences.getBoolean
                ("nature_sounds", false);
        natureSoundsButton.setSelected(natureSoundsValue);

    }


}