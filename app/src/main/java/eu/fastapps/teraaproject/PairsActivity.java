package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class PairsActivity extends AppCompatActivity {
    static final int ROWS = 3;
    static final int COLUMNS= 4;

    int[] data = new int[ROWS*COLUMNS];
    boolean[] flipped = new boolean[ROWS*COLUMNS];
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pairs);

        initData();

    }


    void initData(){
        for(int i = 0; i < data.length; i++){
            data[i] = i/2;
            flipped[i] = false;
        }

        for(int i = 0; i < data.length; i++){
            int n1 = rand.nextInt(12);
            int n2 = rand.nextInt(12);
            int tmp = data[n1];
            data[n1] = data[n2];
            data[n2] = tmp;
        }

    }
}