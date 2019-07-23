package com.example.whackahero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DifficultyActivity extends AppCompatActivity {
    private Set<Hero> heroesList = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        Helper.extractHero(DifficultyActivity.this, new Helper.HeroListener() {
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
                SingletonHeroesList.getInstance().setHeroesList(heroesList);
            }
        });

        Button btEasy = findViewById(R.id.btEasy);
        btEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivity = new Intent(DifficultyActivity.this, MainActivity.class);
                goToMainActivity.putExtra("booleen", false);
                startActivity(goToMainActivity);
            }
        });

        Button btHard = findViewById(R.id.btHard);
        btHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivity = new Intent(DifficultyActivity.this, MainActivity.class);
                goToMainActivity.putExtra("booleen", true);
                startActivity(goToMainActivity);
            }
        });
    }
}
