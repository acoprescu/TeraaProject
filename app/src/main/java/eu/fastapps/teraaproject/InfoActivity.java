package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ListView listView=(ListView)findViewById(R.id.info_list);
        //TextView textView=(TextView)findViewById(R.id.textView);
        String[] listItem = getResources().getStringArray(R.array.info_options);

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
//
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.infolist_layout, R.id.infolist_entry, listItem);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            // TODO Auto-generated method stub
            String value=adapter.getItem(position);
//            Toast.makeText(getApplicationContext(),
//                    "(" + position + ")" +
//                            value + " ",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, InfoDetailsActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });

    }
}