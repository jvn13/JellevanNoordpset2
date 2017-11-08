package com.example.jelle.jellevannoord_pset2;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assetManager = getAssets();
        // Create a Story with the chosen story file
        try {
            Story test = new Story(assetManager.open("madlib0_simple.txt"));
            TextView myAwesomeTextView = (TextView)findViewById(R.id.descTextView);
            //myAwesomeTextView.setText(test.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
