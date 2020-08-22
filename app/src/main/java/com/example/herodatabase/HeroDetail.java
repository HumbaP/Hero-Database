package com.example.herodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.herodatabase.ui.main.HeroDetailFragment;

public class HeroDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HeroDetailFragment.newInstance())
                    .commitNow();
        }
    }
}