package com.example.whackahero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Hero> heroesList = new ArrayList<>();
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private ImageView iv7;
    private ImageView iv8;
    private ImageView ivAnswer;
    private int answer;
    private int score;
    private int nbClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] intervalle = {2000};
        final TextView tvScore = findViewById(R.id.tvScore);
        ivAnswer = findViewById(R.id.ivAnswer);
        iv1 = findViewById(R.id.iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 0;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv1.setEnabled(false);


                }
                nbClick++;
            }
        });

        iv2 = findViewById(R.id.iv2);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 1;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv2.setEnabled(false);
                }
                nbClick++;
            }
        });

        iv3 = findViewById(R.id.iv3);
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 2;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv3.setEnabled(false);
                }
                nbClick++;
            }
        });

        iv4 = findViewById(R.id.iv4);
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 3;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv4.setEnabled(false);
                }
                nbClick++;
            }
        });

        iv5 = findViewById(R.id.iv5);
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 4;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv5.setEnabled(false);
                }
                nbClick++;
            }
        });

        iv6 = findViewById(R.id.iv6);
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 5;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv6.setEnabled(false);
                }
                nbClick++;
            }
        });

        iv7 = findViewById(R.id.iv7);
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 6;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv7.setEnabled(false);
                }
                nbClick++;
            }
        });

        iv8 = findViewById(R.id.iv8);
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 7;
                if (result == answer) {
                    score++;
                    tvScore.setText(String.valueOf(score));
                    checkScore(score, intervalle);
                    iv8.setEnabled(false);
                }
                nbClick++;
            }
        });

        Helper.extractHero(MainActivity.this, new Helper.HeroListener() {
            @Override
            public void onHeroesLoaded(List<Hero> heroes) {
                int count = 0;
                while (count < 8) {
                    Random r = new Random();
                    int index = r.nextInt((500 - 0) + 1) + 0;
                    Hero hero = heroes.get(index);
                    heroesList.add(hero);
                    count++;
                }
                List<ImageView> ivList = new ArrayList<>();
                ivList.add(iv1);
                ivList.add(iv2);
                ivList.add(iv3);
                ivList.add(iv4);
                ivList.add(iv5);
                ivList.add(iv6);
                ivList.add(iv7);
                ivList.add(iv8);

                for (int i = 0; i < ivList.size(); i++) {
                    Hero hero = heroesList.get(i);
                    String url = hero.getUrl();
                    Glide.with(MainActivity.this).load(url).into(ivList.get(i));
                }

                Runnable runnable = new Runnable() {

                    @Override
                    public void run() {


                        setImage(heroesList, ivAnswer);

                        ivAnswer.postDelayed(this, intervalle[0]);
                    }
                };
                runnable.run();

            }
        });
    }

    private void checkScore(int score, int[] intervalle) {
        if (score > 0 && score % 10 == 0 && intervalle[0] > 0) {
            intervalle[0] -= 500;
        }
        if (score >= 40) {
            Intent goToNewActivity = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(goToNewActivity);
        }
    }

    private void setImage(List<Hero> heroesList, ImageView ivAnswer) {

        Random r = new Random();
        int index = r.nextInt((7 - 0) + 1) + 0;
        if (index == answer) {
            index = r.nextInt((7 - 0) + 1) + 0;
        }
        Hero heroAnswer = heroesList.get(index);
        String urlAnswer = heroAnswer.getUrl();
        answer = index;
        Glide.with(MainActivity.this).load(urlAnswer).into(ivAnswer);
        iv1.setEnabled(true);
        iv2.setEnabled(true);
        iv3.setEnabled(true);
        iv4.setEnabled(true);
        iv5.setEnabled(true);
        iv6.setEnabled(true);
        iv7.setEnabled(true);
        iv8.setEnabled(true);

    }
}
