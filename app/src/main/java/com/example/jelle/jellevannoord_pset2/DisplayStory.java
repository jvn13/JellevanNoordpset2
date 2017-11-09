package com.example.jelle.jellevannoord_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DisplayStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_story);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final Story story = (Story) intent.getSerializableExtra("STORY");
        // Print the complete story
        EditText fullStory = findViewById(R.id.fullStory);
        fullStory.setText(story.toString());
    }

    @Override
    public void onBackPressed() {
        // When the back button is pressed, the user goes all the way back to the MainActivity
        Intent intent = new Intent(DisplayStory.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
