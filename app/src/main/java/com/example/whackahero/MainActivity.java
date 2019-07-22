package com.example.whackahero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView test = findViewById(R.id.iv);

        Helper.extractHero(MainActivity.this, new Helper.HeroListener() {
            @Override
            public void onHeroesLoaded(List<Hero> heroes) {
                Hero hero = heroes.get(0);
                String url = hero.getUrl();

                Glide.with(MainActivity.this).load(url) .into(test);
            }
        });



    }
}
