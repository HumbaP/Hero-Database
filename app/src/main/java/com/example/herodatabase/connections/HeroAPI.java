package com.example.herodatabase.connections;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeroAPI {
    @GET("{id}")
    Call<ResponseBody> getHeroFromId(@Path("id") String id);
    @GET("search/{name}")
    Call<ResponseBody> searchHero(@Path("name") String name);
}

