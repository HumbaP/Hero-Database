package com.example.herodatabase.connections.requests;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseHeroAPIResponse {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private HeroAPIResponse heroAPIResponse;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HeroAPIResponse getBaseHeroAPIResponse() {
        return heroAPIResponse;
    }

    public void setBaseHeroAPIResponse(HeroAPIResponse heroAPIResponse) {
        this.heroAPIResponse = heroAPIResponse;
    }
}
