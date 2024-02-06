package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    TextView mshowCount=(TextView) findViewById(R.id.show_count);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showtoast( View view ){
        Toast.makeText(this, "Button Toast Clicked",Toast.LENGTH_SHORT).show();
    }
    public void countup( View view){
        ++mCount;
        if(mshowCount != null) {
            mshowCount.setText(Integer.toString(mCount));
        }
    }
}