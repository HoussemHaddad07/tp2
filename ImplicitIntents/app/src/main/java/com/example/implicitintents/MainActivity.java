package com.example.implicitintents;

import static androidx.core.app.ShareCompat.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private BreakIterator mWebsiteEditText;
    private BreakIterator mLocationEditText;
    private BreakIterator mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if( uri != null) {
            String uri_string = getString(R.string.uri_label) + uri.toString();
            TextView textView = findViewById(R.id.text_uri_message);
        }
    }
    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivities(new Intent[]{intent});
        } else {
            Log.d("implicite intent ", "cant handle this intent");;
        }
    }
    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo: 0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intents", "Can't handle this intent!");
        }
    }

    public void shareText(View view){
        String txt = mShareTextEditText.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(txt)
            .startChooser();
    }
}