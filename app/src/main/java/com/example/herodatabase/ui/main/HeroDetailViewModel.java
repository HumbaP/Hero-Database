package com.example.herodatabase.ui.main;

import android.app.Application;
import android.media.Image;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.herodatabase.R;
import com.example.herodatabase.connections.APIClient;
import com.example.herodatabase.connections.HeroAPI;
import com.example.herodatabase.connections.requests.HeroAPIResponse;
import com.example.herodatabase.models.SuperHero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroDetailViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel


    public MutableLiveData<SuperHero> heroFound = new MutableLiveData<>();

    public HeroDetailViewModel(@NonNull Application application) {
        super(application);

    }




    public void getHero(String id){
        HeroAPI heroClient = APIClient.getClient(getApplication().getString(R.string.hero_base_api_url)+"/"+getApplication().getString(R.string.hero_auth_code)+"/").create(HeroAPI.class);
            Call<SuperHero> heroResponseByIDCall = heroClient.getHeroFromId(id);
            heroResponseByIDCall.enqueue(new Callback<SuperHero>() {
                @Override
                public void onResponse(Call<SuperHero> call, Response<SuperHero> response) {
                    Log.d("TAGAQUI", "Nais");
                    int statusCode = response.code();
                    SuperHero hero= response.body();
                    heroFound.setValue(hero);
                }

                @Override
                public void onFailure(Call<SuperHero> call, Throwable t) {
                    //Something is missing
                    Log.d("NO", "NONais");

                }
            });
    }
}