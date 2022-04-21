package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExerciceActivity extends AppCompatActivity {

    TextView title;
    Button nextbutton;
    pl.droidsonroids.gif.GifImageView GIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        title = findViewById(R.id.ex_title);
        nextbutton = findViewById(R.id.button);
        GIF = findViewById(R.id.gif);
        nextbutton.setOnClickListener((v)->finish());
    }

    @Override
    public void onPause() {
        super.onPause();

        ((TeraaApplication)getApplication()).stopSound();

    }

    @Override
    public void onResume() {
        super.onResume();

        int soundId = getIntent().getIntExtra("sound", -1);
        ((TeraaApplication)getApplication()).playSound(soundId);
    }
}
