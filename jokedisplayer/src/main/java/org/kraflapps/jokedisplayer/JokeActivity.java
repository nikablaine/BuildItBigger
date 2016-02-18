package org.kraflapps.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(JOKE_KEY)) {
            String joke = intent.getStringExtra(JOKE_KEY);
            TextView textView = (TextView) findViewById(R.id.joke_text);
            textView.setText(joke);
        }
    }
}
