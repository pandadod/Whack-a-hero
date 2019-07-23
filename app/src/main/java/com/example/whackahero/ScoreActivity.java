package com.example.whackahero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        User user = UserSingleton.getInstance().getUser();

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", -1);
        int accuracy = intent.getIntExtra("accuracy", -1);
        Button btPlayAgain = findViewById(R.id.btPlayAgain);
        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDifficultyActivity = new Intent(ScoreActivity.this, DifficultyActivity.class);
                startActivity(goToDifficultyActivity);
            }
        });

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
        final List<User> usersList = new ArrayList<>();
        RecyclerView rvRecipe = findViewById(R.id.rvScores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvRecipe.setLayoutManager(layoutManager);
        final UserAdapter adapter = new UserAdapter(usersList);
        rvRecipe.setAdapter(adapter);

        if (score > user.getScoreMax()) {
            user.setScoreMax(score);
            SingletonVolley.getInstance(ScoreActivity.this).modifyUser(user, new Consumer<User>() {
                @Override
                public void accept(User user) {
                    UserSingleton.getInstance().setUser(user);
                    SingletonVolley.getInstance(ScoreActivity.this).getAllUsers(new Consumer<List<User>>() {
                        @Override
                        public void accept(List<User> users) {
                            usersList.addAll(users);
                            Collections.sort(usersList, new Comparator<User>() {
                                @Override
                                public int compare(User o1, User o2) {
                                    return o2.getScoreMax() > o1.getScoreMax() ? 1 : -1;
                                }
                            });
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            });
        } else {
            SingletonVolley.getInstance(ScoreActivity.this).getAllUsers(new Consumer<List<User>>() {
                @Override
                public void accept(List<User> users) {
                    usersList.addAll(users);
                    Collections.sort(usersList, new Comparator<User>() {
                        @Override
                        public int compare(User o1, User o2) {
                            return o2.getScoreMax() > o1.getScoreMax() ? 1 : -1;
                        }
                    });
                    adapter.notifyDataSetChanged();
                }
            });
        }

    }
}
