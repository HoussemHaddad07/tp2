package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openWebsite (View view) {
// Get the URL text.
        String url = mWebsiteEdit Text.getText().toString();
// Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
// Find an activity to handle the intent and start that activity.
        if (intent.resolve Activity (getPackage Manager()) != null) {
            startActivity (intent);
        } else {
            Log.d( tag: "ImplicitIntents", msg: "Can't handle this intent!");
        }
}