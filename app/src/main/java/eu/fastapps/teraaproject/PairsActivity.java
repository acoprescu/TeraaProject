package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class PairsActivity extends AppCompatActivity {
    static final int ROWS = 3;
    static final int COLUMNS= 4;
    static final int SIZE = ROWS * COLUMNS;

    int[] data = new int[SIZE];
    boolean[] flipped = new boolean[SIZE];
    ImageView[] imageViews;
    Drawable[] drawables;

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pairs);

        initData();
        initViews();

        updateImages();
    }

    void updateImages(){
        for(int i = 0; i < SIZE; i++){
            imageViews[i].setImageDrawable(drawables[data[i]]);
        }
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

    void initViews(){
        imageViews = new ImageView[]{
                (ImageView) findViewById(R.id.imageView0),
                (ImageView) findViewById(R.id.imageView1),
                (ImageView) findViewById(R.id.imageView2),

                (ImageView) findViewById(R.id.imageView3),
                (ImageView) findViewById(R.id.imageView4),
                (ImageView) findViewById(R.id.imageView5),

                (ImageView) findViewById(R.id.imageView6),
                (ImageView) findViewById(R.id.imageView7),
                (ImageView) findViewById(R.id.imageView8),

                (ImageView) findViewById(R.id.imageView9),
                (ImageView) findViewById(R.id.imageView10),
                (ImageView) findViewById(R.id.imageView11),
        };

        drawables = new Drawable[]{
                getResources().getDrawable( R.drawable.pairimg0, null),
                getResources().getDrawable( R.drawable.pairimg1, null),
                getResources().getDrawable( R.drawable.pairimg2, null),
                getResources().getDrawable( R.drawable.pairimg3, null),
                getResources().getDrawable( R.drawable.pairimg4, null),
                getResources().getDrawable( R.drawable.pairimg5, null),
        } ;
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