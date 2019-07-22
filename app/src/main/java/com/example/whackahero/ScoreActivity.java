package com.example.whackahero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", -1);
        int accuracy = intent.getIntExtra("accuracy", -1);

        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText("Your final score is : " + score);
        TextView tvAccuracy = findViewById(R.id.tvAccuracy);
        tvAccuracy.setText("Your accuracy is : " + score * 100 / accuracy + "%");
    }
}
