package com.example.jelle.jellevannoord_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FillWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_word);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final Story story = (Story) intent.getSerializableExtra("STORY");
        // set the description for the next placeholder
        TextView placeholder = findViewById(R.id.placeholderTextView);
        String next = story.getNextPlaceholder();
        placeholder.setText(getResources().getString(R.string.placeholder, next));

        TextView remaining = findViewById(R.id.remainingTextView);
        remaining.setText(getResources().getString(R.string.remaining, String.valueOf(story.getPlaceholderRemainingCount())));

        Button okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText fillInText = findViewById(R.id.fillInText);
                String word = fillInText.getText().toString();
                if(word.matches("")) {
                    // No word is entered, display an error
                    TextView error = findViewById(R.id.errorTextView);
                    error.setText(getResources().getString(R.string.empty_error));
                } else {
                    // Fill in the entered word
                    story.fillInPlaceholder(word);
                    if(story.isFilledIn()) {
                        // The story is finished, go to the story display activity
                        Intent wordIntent = new Intent(FillWordActivity.this, DisplayStory.class);
                        wordIntent.putExtra("STORY", story);
                        startActivity(wordIntent);
                    } else {
                        Intent wordIntent = new Intent(FillWordActivity.this, FillWordActivity.class);
                        wordIntent.putExtra("STORY", story);
                        startActivity(wordIntent);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FillWordActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
