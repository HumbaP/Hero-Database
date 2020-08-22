package com.example.herodatabase.ui.main;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.herodatabase.HeroDetail;
import com.example.herodatabase.R;
import com.example.herodatabase.connections.APIClient;
import com.example.herodatabase.connections.HeroAPI;
import com.example.herodatabase.connections.requests.HeroAPIResponse;
import com.example.herodatabase.models.SuperHero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroListViewModel extends AndroidViewModel {

    public MutableLiveData<ArrayList<SuperHero>> superHeroList= new MutableLiveData<>(new ArrayList<SuperHero>());
    public MutableLiveData<Integer> starting = new MutableLiveData<>(1);
    public MutableLiveData<Integer> limit = new MutableLiveData<>(10);
    private int index=0;
    public MutableLiveData<String> heroName = new MutableLiveData<>();



    public HeroListViewModel(@NonNull Application application) {
        super(application);
    }

    public void reloadHeroes(){
        final ArrayList<SuperHero> heroes = new ArrayList<>();
        HeroAPI heroClient = APIClient.getClient(getApplication().getString(R.string.hero_base_api_url)+"/"+getApplication().getString(R.string.hero_auth_code)+"/").create(HeroAPI.class);
        for (index=0;index<limit.getValue();index++){
            Call<SuperHero> heroResponseByIDCall = heroClient.getHeroFromId(""+(index+starting.getValue()));
            heroResponseByIDCall.enqueue(new Callback<SuperHero>() {
                @Override
                public void onResponse(Call<SuperHero> call, Response<SuperHero> response) {
                    Log.d("TAGAQUI", "Nais");
                    int statusCode = response.code();
                    SuperHero hero= response.body();
                    heroes.add(hero);
                    if(Integer.parseInt(hero.getId())==limit.getValue()+starting.getValue()-1){
                        superHeroList.setValue(heroes);
                        starting.setValue(limit.getValue()+starting.getValue());

                    }
                }

                @Override
                public void onFailure(Call<SuperHero> call, Throwable t) {
                    //Something is missing
                    Log.d("NO", "NONais");

                }
            });
        }
    }

    public void searchHero(String name){
        this.heroName.setValue(name);
        HeroAPI heroClient = APIClient.getClient(getApplication().getString(R.string.hero_base_api_url)+"/"+getApplication().getString(R.string.hero_auth_code)+"/").create(HeroAPI.class);
        Call<HeroAPIResponse> searchedHeroCall = heroClient.searchHero(name);
        searchedHeroCall.enqueue(new Callback<HeroAPIResponse>() {
            @Override
            public void onResponse(Call<HeroAPIResponse> call, Response<HeroAPIResponse> response) {
                //Hero found
               try{
                   int statusCode = response.code();
                   HeroAPIResponse heroAPIResponse = response.body();
                   if(!heroAPIResponse.getResponse().equals("error")){
                       Intent intent = new Intent(getApplication(), HeroDetail.class);
                       intent.putExtra("HeroId", heroAPIResponse.getResults().get(0).getId());
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                       getApplication().startActivity(intent);
                    }
               }catch (Exception e){
                    e.getStackTrace();
               }
            }
            @Override
            public void onFailure(Call<HeroAPIResponse> call, Throwable t) {
                //Something is missing
                HeroListViewModel.this.heroName.setValue("");
            }
        });
    }
}
