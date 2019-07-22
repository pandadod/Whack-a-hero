package com.example.whackahero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView iv1 = findViewById(R.id.iv1);
        final ImageView iv2 = findViewById(R.id.iv2);
        final ImageView iv3 = findViewById(R.id.iv3);
        final ImageView iv4 = findViewById(R.id.iv4);
        final ImageView iv5 = findViewById(R.id.iv5);
        final ImageView iv6 = findViewById(R.id.iv6);
        final ImageView iv7 = findViewById(R.id.iv7);
        final ImageView iv8 = findViewById(R.id.iv8);
        final ImageView ivAnswer = findViewById(R.id.ivAnswer);

        Helper.extractHero(MainActivity.this, new Helper.HeroListener() {
            @Override
            public void onHeroesLoaded(List<Hero> heroes) {
                List<Hero> heroesList = new ArrayList<>();
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

                Random r = new Random();
                int index = r.nextInt((7 - 0) + 1) + 0;
                Hero heroAnswer = heroesList.get(index);
                String urlAnswer = heroAnswer.getUrl();
                Glide.with(MainActivity.this).load(urlAnswer).into(ivAnswer);

                for (int i = 0; i < ivList.size(); i++) {
                    Hero hero = heroesList.get(i);
                    String url = hero.getUrl();
                    Glide.with(MainActivity.this).load(url).into(ivList.get(i));
                    heroes.remove(hero);
                }

            }
        });

    }
}
