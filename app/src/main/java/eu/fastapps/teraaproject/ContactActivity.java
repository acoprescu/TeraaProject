package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ((Button) findViewById(R.id.btnOK)).setOnClickListener(v -> {
            String sub = ((EditText) findViewById(R.id.txtSubject)).getText().toString();
            String mess = ((EditText) findViewById(R.id.txtMessage)).getText().toString();
            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.putExtra(Intent.EXTRA_CC, new String[]{"alexia.florete@gmail.com"});
            mail.putExtra(Intent.EXTRA_CC, new String[]{"anastasiatgab@gmail.com"});
            mail.putExtra(Intent.EXTRA_CC, new String[]{"theodora.oprescu@gmail.com"});
            mail.putExtra(Intent.EXTRA_CC, new String[]{"ruxandraflorescu12@gmail.com"});
            mail.putExtra(Intent.EXTRA_CC, new String[]{"primaadresa89@gmail.com"});
            mail.putExtra(Intent.EXTRA_SUBJECT, sub);
            mail.putExtra(Intent.EXTRA_TEXT, mess);
            mail.setType("message/rfc822");
            startActivity(Intent.createChooser(mail, "Send email via:"));
        });
    }
}