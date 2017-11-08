package com.example.jelle.jellevannoord_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    AssetManager assetManager;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assetManager = getAssets();
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.storyItems, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String[] filesArray = {"madlib0_simple", "madlib1_tarzan","madlib2_university","madlib3_clothes","madlib4_dance"};
                TextView description = findViewById(R.id.descTextView);
                String filename;
                if(spinner.getSelectedItemPosition() == 0) {
                    filename = filesArray[new Random().nextInt(filesArray.length)];
                } else {
                    filename = filesArray[spinner.getSelectedItemPosition()-1];
                }
                // Create a Story with the chosen story file
                try {
                    Story story = new Story(assetManager.open(filename + ".txt"));
                    Intent intent = new Intent(MainActivity.this, FillWordActivity.class);
                    intent.putExtra("TEST", story);
                    startActivity(intent);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
