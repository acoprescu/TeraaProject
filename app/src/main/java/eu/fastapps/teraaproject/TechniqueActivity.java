package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TechniqueActivity extends AppCompatActivity {

    int step = 0;

    TextView title;
    Button nextButton;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technique);

        title = findViewById(R.id.title);

        setTechniqueTitle();

        nextButton = findViewById(R.id.button_next);
        nextButton.setOnClickListener(
                (v) -> onNext()
        );

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
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


    private void onNext() {
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        
        switch(step){
            case 0:
                editText5.setVisibility(View.GONE);
                break;
            case 1:
                editText4.setVisibility(View.GONE);
                break;
            case 2:
                editText3.setVisibility(View.GONE);
                break;
            case 3:
                editText2.setVisibility(View.GONE);
                break;
            case 4:
                editText1.setVisibility(View.GONE);
                break;
        }

        step++;
        setTechniqueTitle();
    }

    void setTechniqueTitle(){
        switch(step){
            case 0:
                title.setText("Name 5 things that you can see");
                break;
            case 1:
                title.setText("Name 4 things that you can touch");
                break;
            case 2:
                title.setText("Name 3 things that you can hear");
                break;
            case 3:
                title.setText("Name 2 things that you can smell");
                break;
            case 4:
                title.setText("Name one thing that you can taste");
                break;
        }
    }
}
