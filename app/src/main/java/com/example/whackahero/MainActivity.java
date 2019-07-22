package com.example.whackahero;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                }
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
                }
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
                }
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
                }
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
                }
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
                }
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
                }
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
                }
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
                new Runnable() {
                    int intervalle = 1000;

                    @Override
                    public void run() {
                        setImage(heroesList, ivAnswer);
                        ivAnswer.postDelayed(this, intervalle);
                    }
                }.run();
            }
        });
    }

    private void setImage(List<Hero> heroesList, ImageView ivAnswer) {

        Random r = new Random();
        int index = r.nextInt((7 - 0) + 1) + 0;
        Hero heroAnswer = heroesList.get(index);
        String urlAnswer = heroAnswer.getUrl();
        answer = index;
        Glide.with(MainActivity.this).load(urlAnswer).into(ivAnswer);
    }
}
