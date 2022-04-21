package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_details);

        int position = getIntent().getIntExtra("position", -1);

        String[] options = getResources().getStringArray(R.array.info_options);
        ((TextView)findViewById(R.id.title)).setText(options[position]);

        String[] details = getResources().getStringArray(R.array.info_details);
        ((TextView)findViewById(R.id.content)).setText(details[position]);

    }
}