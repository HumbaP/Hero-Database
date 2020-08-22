package com.example.herodatabase.connections;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit client = null;

    public static Retrofit getClient(String server){
        if(client == null || !client.baseUrl().equals(server)){
            client = new Retrofit.Builder()
                    .baseUrl(server)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return client;
    }
}
