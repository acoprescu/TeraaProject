package eu.fastapps.teraaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class InfoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_details);

        int position = getIntent().getIntExtra("position", -1);

        String[] options = getResources().getStringArray(R.array.info_options);
        String[] details = getResources().getStringArray(R.array.info_details);

        WebView webView = findViewById(R.id.content);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.setWebViewClient(new Callback());

        webView.setBackgroundColor(
                getResources().getColor(R.color.backgroundColor, null));

        String data = "<!DOCTYPE> <html><body> <h2>$$$1</h2> $$$2 <body><html>"
                .replace("$$$1",options[position])
                .replace("$$$2",details[position]);
        //System.out.println("!!! " + data);
        webView.loadDataWithBaseURL(null, data , "text/html", "utf-8", null);

    }

    private class Callback extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


    }
}