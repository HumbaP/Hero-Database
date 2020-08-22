package com.example.herodatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herodatabase.models.PowerStats;
import com.example.herodatabase.models.SuperHero;
import com.example.herodatabase.ui.main.HeroDetailViewModel;
import com.example.herodatabase.utils.ImageUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class HeroDetail extends AppCompatActivity {


    private HeroDetailViewModel mViewModel;
    private TextView intelligenceView, strengthView, nameView, publisherView, powerView, speedView, durabilityView,fullNameView,combatView;
    private ImageView photoView;
    private View alignmentView;
    private String heroId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail_activity);
        mViewModel = ViewModelProviders.of(this).get(HeroDetailViewModel.class);
        heroId = getIntent().getStringExtra("HeroId");
        if(heroId!=null)
            mViewModel.getHero(heroId);
        searchViews();
        bindViewModel();
    }

    private void searchViews(){
        intelligenceView =   findViewById(R.id.intelligence);
        strengthView =   findViewById(R.id.strength);
        nameView =   findViewById(R.id.hero_detail_name);
        publisherView =   findViewById(R.id.detail_hero_publisher);
        powerView =   findViewById(R.id.power);
        speedView =   findViewById(R.id.speed);
        combatView =   findViewById(R.id.combat);
        durabilityView =   findViewById(R.id.durability);
        fullNameView =   findViewById(R.id.detail_hero_full_name);
        photoView =   findViewById(R.id.hero_detail_image);
        alignmentView =   findViewById(R.id.hero_alignment);
    }

    private void bindViewModel(){
        mViewModel.heroFound.observe(this, new Observer<SuperHero>() {
            @Override
            public void onChanged(SuperHero hero) {
                PowerStats heroStats = hero.getPowerstats();
                intelligenceView.setText(heroStats.getIntelligence());
                strengthView.setText(heroStats.getStrength());
                nameView.setText(hero.getName());
                publisherView.setText(hero.getBiography().getPublisher());
                powerView.setText(heroStats.getPower());
                speedView.setText(heroStats.getSpeed());
                combatView.setText(heroStats.getCombat());
                durabilityView.setText(heroStats.getDurability());
                fullNameView.setText(hero.getBiography().getFullName().length()>0 ?hero.getBiography().getFullName(): "-"  );
                alignmentView.setBackgroundColor(hero.getBiography().getAlignment().equals("good")? Color.GREEN: Color.RED);
                Picasso.get().load(hero.getImage().getUrl()).into(photoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        //TODO: Make a callback to normalize size and add circular feel
                        //Rounding Image
                        photoView.setImageDrawable(ImageUtils.RoundImage(photoView));
                    }

                    @Override
                    public void onError(Exception e) {
                        photoView.setImageResource(R.drawable.ic_launcher_background);
                    }
                });

            }
        });
    }

}