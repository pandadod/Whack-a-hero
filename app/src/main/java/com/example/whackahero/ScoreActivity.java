package com.example.whackahero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        User user = UserSingleton.getInstance().getUser();

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", -1);
        int accuracy = intent.getIntExtra("accuracy", -1);

        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText("Your final score is : " + score);
        TextView tvAccuracy = findViewById(R.id.tvAccuracy);
        tvAccuracy.setText("Your accuracy is : " + score * 100 / accuracy + "%");
        TextView tvPhrase = findViewById(R.id.tvPhrase);
        if (score < 20) {
            tvPhrase.setText("Thanks for playing but this game is not made for you, obviously !");
        }
        if (score >= 20 && score < 40) {
            tvPhrase.setText("Not bad ! Feel free to purchase the app on Google Play Store to try again");
        }
        if (score >= 40 && score <= 60) {
            tvPhrase.setText("Well done ! Yet you still have a long way to beat our master guru Bastien !");
        }
        if (score > 60) {
            tvPhrase.setText("Congratulations, but princess Peach is in another castle, try again !");
        }

        if (score > user.getScoreMax()) {
            user.setScoreMax(score);
            SingletonVolley.getInstance(ScoreActivity.this).modifyUser(user, new Consumer<User>() {
                @Override
                public void accept(User user) {
                    UserSingleton.getInstance().setUser(user);
                }
            });
        }
    }
}
