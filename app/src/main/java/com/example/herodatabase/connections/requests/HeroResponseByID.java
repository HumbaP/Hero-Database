package com.example.herodatabase.connections.requests;
import com.example.herodatabase.models.SuperHero;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeroResponseByID {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private SuperHero superHero;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SuperHero getSuperHero() {
        return superHero;
    }

    public void setSuperHero(SuperHero superHero) {
        this.superHero = superHero;
    }
}
