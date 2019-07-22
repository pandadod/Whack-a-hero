package com.example.whackahero;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private Set<Hero> heroesList = new HashSet<>();
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
    private MediaPlayer music;
    private float speed;
    private ProgressBar lifeBar;
    private GifImageView ivStar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speed = 1;
        music = MediaPlayer.create(MainActivity.this, R.raw.music_tetris);
        music.start();

        lifeBar = findViewById(R.id.lifebar);
        ivStar= findViewById(R.id.ivstar);
        lifeBar.setMax(100);
        lifeBar.setProgress(100);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv1.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv1.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv2.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv2.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv3.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv3.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv4.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv4.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv5.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv5.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv6.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv6.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv7.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv7.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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
                    tvScore.setText("Score : " + score);
                    checkScore(score, intervalle);
                    iv8.setEnabled(false);
                    ivStar.setImageResource(R.drawable.star_jumping);
                    ivStar.setVisibility(View.VISIBLE);
                } else {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    iv8.setEnabled(false);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
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

                int countHero = 0;
                for (Hero hero : heroesList) {
                    String url = hero.getUrl();
                    Glide.with(MainActivity.this).load(url).into(ivList.get(countHero));
                    countHero++;
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
            intervalle[0] -= 200;
            speed += 0.1;
            music.setPlaybackParams(music.getPlaybackParams().setSpeed(speed));
            lifeBar.setProgress(100);
            nbClick = 0;
        }
        if (intervalle[0] < 400) {
            music.stop();
            Intent goToNewActivity = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(goToNewActivity);
        }
    }

    private void checkLose(int nbClick) {
        if (nbClick >= 5) {
            music.stop();
            Intent goToLoseActivity = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(goToLoseActivity);
        }
    }

    private void setImage(Set<Hero> heroesList, ImageView ivAnswer) {

        Random r = new Random();
        int index = r.nextInt((7 - 0) + 1) + 0;
        if (index == answer) {
            index = r.nextInt((7 - 0) + 1) + 0;
        }

        int count = 0;
        for (Hero hero : heroesList) {
            if (count == index) {
                String urlAnswer = hero.getUrl();
                answer = index;
                Glide.with(MainActivity.this).load(urlAnswer).into(ivAnswer);
                if (iv1.isEnabled() && iv2.isEnabled() &&iv3.isEnabled() &&iv4.isEnabled() &&iv5.isEnabled() &&iv6.isEnabled() &&iv7.isEnabled() &&iv8.isEnabled()) {
                    nbClick++;
                    lifeBar.setProgress(100 - nbClick * 20);
                    checkLose(nbClick);
                    ivStar.setImageResource(R.drawable.dog_laughing);
                    ivStar.setVisibility(View.VISIBLE);
                }
                iv1.setEnabled(true);
                iv2.setEnabled(true);
                iv3.setEnabled(true);
                iv4.setEnabled(true);
                iv5.setEnabled(true);
                iv6.setEnabled(true);
                iv7.setEnabled(true);
                iv8.setEnabled(true);
                ivStar.setVisibility(View.INVISIBLE);
            }
            count++;
        }
    }
}
