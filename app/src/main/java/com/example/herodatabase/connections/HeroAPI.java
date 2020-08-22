package com.example.herodatabase.connections;

import com.example.herodatabase.connections.requests.*;
import com.example.herodatabase.models.SuperHero;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeroAPI {
    @GET("{id}")
    Call<SuperHero> getHeroFromId(@Path("id") String id);
    @GET("search/{name}")
    Call<BaseHeroAPIResponse> searchHero(@Path("name") String name);
}

