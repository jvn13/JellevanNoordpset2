package com.example.jelle.jellevannoord_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FillWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_word);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Story message = (Story) intent.getSerializableExtra("TEST");
        TextView testintent = findViewById(R.id.testIntent);
        testintent.setText(message.toString());
    }
}
