package com.example.herodatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.herodatabase.adapters.HeroListAdapter;
import com.example.herodatabase.models.SuperHero;
import com.example.herodatabase.ui.main.HeroListViewModel;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    RecyclerView heroRecycler;
    HeroListAdapter heroAdapter;
    private SwipeRefreshLayout swipeContainer;
    private EditText searchEditText;
    private Button searchButton;

    HeroListViewModel heroVM ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroRecycler = findViewById(R.id.hero_list);
        searchEditText = findViewById(R.id.search_hero);
        searchButton = findViewById(R.id.search_button);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.simpleSwipeRefreshLayout);
        heroVM = ViewModelProviders.of(this).get(HeroListViewModel.class);

        heroVM.superHeroList.observe(this, new Observer<ArrayList<SuperHero>>() {
            @Override
            public void onChanged(ArrayList<SuperHero> superHeroes) {
                heroAdapter = new HeroListAdapter(MainActivity.this, superHeroes);
                heroRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                heroRecycler.setAdapter(heroAdapter);
                swipeContainer.setRefreshing(false);
            }
        });
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                heroAdapter.clear();
                heroVM.reloadHeroes();
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchEditText.getText()!=null && searchEditText.getText().length()>0){
                    heroVM.searchHero(searchEditText.getText().toString());
                }
            }
        });
        heroVM.reloadHeroes();

    }
}