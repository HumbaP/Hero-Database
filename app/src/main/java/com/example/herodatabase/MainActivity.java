package com.example.herodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.herodatabase.connections.APIClient;
import com.example.herodatabase.connections.HeroAPI;
import com.example.herodatabase.connections.requests.HeroResponseByID;
import com.example.herodatabase.models.SuperHero;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HeroAPI heroClient = APIClient.getClient(getString(R.string.hero_base_api_url)+"/"+getString(R.string.hero_auth_code)+"/").create(HeroAPI.class);
        Call<SuperHero> heroResponseByIDCall = heroClient.getHeroFromId("1");
        SuperHero response = null;
        heroResponseByIDCall.enqueue(new Callback<SuperHero>() {
            @Override
            public void onResponse(Call<SuperHero> call, Response<SuperHero> response) {
                Log.d("TAGAQUI", "Nais");
                int statusCode = response.code();
                SuperHero user = response.body();
            }

            @Override
            public void onFailure(Call<SuperHero> call, Throwable t) {
                Log.d("NO", "NONais");

            }
        });

    }
}