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
    }

    /*
    View.VISIBLE
    View.INVISIBLE
    View.GONE
     */

    private void onNext() {
        editText1.setText("");
        editText2.setText("");
        //...
        switch(step){
            case 0:
                //editText5.setVisibility(View.GONE);
                break;
            case 1:
                //editText4.setVisibility(View.GONE);
                // break;
            //case ...
        }

        step++;
        setTechniqueTitle();
    }

    void setTechniqueTitle(){
        switch(step){
            case 0:
                title.setText("Name 5 things that you can see...");
                break;
            case 1:
                title.setText("Name 4 things that you can touch...");
                break;

        }
    }
}