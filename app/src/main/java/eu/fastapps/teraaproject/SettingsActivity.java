package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SettingsActivity extends AppCompatActivity {

    Button save;
    EditText name, email, password;
    SharedPreferences sp;

    ImageView imageView;
    boolean hasAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Saving state of our app
        // using SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);

        final Switch enabledarkmode = findViewById(R.id.enabledarkmode);
        // When user reopens the app
        // after applying dark/light mode
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            enabledarkmode.setText("Disable Dark Mode");
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            enabledarkmode.setText("Enable Dark Mode");
        }

        enabledarkmode.setChecked(isDarkModeOn);

        enabledarkmode.setOnClickListener(view -> {
            // When user taps the enable/disable
            // dark mode button
            if (isDarkModeOn) {

                // if dark mode is on it
                // will turn it off
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                // it will set isDarkModeOn
                // boolean to false
                editor.putBoolean("isDarkModeOn", false);
                editor.apply();

                // change text of Button
                enabledarkmode.setText("Enable Dark Mode");
            } else {

                // if dark mode is off
                // it will turn it on
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                // it will set isDarkModeOn
                // boolean to true
                editor.putBoolean("isDarkModeOn", true);
                editor.apply();

                // change text of Button
                enabledarkmode.setText("Disable Dark Mode");
            }
        });


        findViewById(R.id.customise).setOnClickListener(
                (v) -> {
                    startActivity(new Intent(this, IntroActivity.class));
                }
        );

        findViewById(R.id.contactus).setOnClickListener(
                (v) -> startActivity(new Intent(this, ContactActivity.class))
        );

        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        save = findViewById(R.id.button_savee);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        String nameStr = sp.getString("name", "");
        name.setText(nameStr);

        String emailStr = sp.getString("email", "");
        email.setText(emailStr);

        String passStr = sp.getString("password", "");
        password.setText(passStr);

        imageView = findViewById(R.id.imageView);
        hasAvatar = sp.getBoolean("avatar", false);
        if(hasAvatar){
            setImage();
        }

        imageView.setOnClickListener(
                (v) -> pickImage()
        );


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String emailStr = email.getText().toString();
                String passStr = password.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name", nameStr);
                editor.putString("email", emailStr);
                editor.putString("password", passStr);
                editor.putBoolean("avatar", hasAvatar);
                editor.commit();
                Toast.makeText(SettingsActivity.this, "Information Saved", Toast.LENGTH_LONG).show();


            }
        });

    }

    int PICK_PHOTO_FOR_AVATAR = 1000;


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                String avatarPath = getFilesDir() + "/avatar";

                InputStream in  = getContentResolver().openInputStream(data.getData());
                OutputStream out = new FileOutputStream(avatarPath);
                if(copyFile(in, out)){
                    setImage();
                    hasAvatar = true;
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    void setImage(){
        try {
            imageView.setImageURI(null);
            String avatarPath = getFilesDir() + "/avatar";
            imageView.setImageURI(Uri.parse(avatarPath));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean copyFile(InputStream in, OutputStream out) throws IOException {
            boolean succes = true;
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }
            catch(Exception e){
             succes = false;
            }
            finally {
                out.close();
            }
            return succes;
    }


}
