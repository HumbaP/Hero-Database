package com.example.herodatabase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuperHero {


    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("powerstats")
    @Expose
    private PowerStats powerstats;
    @SerializedName("biography")
    @Expose
    private Biography biography;
    @SerializedName("appearance")
    @Expose
    private Appearance appearance;
    @SerializedName("work")
    @Expose
    private Work work;
    @SerializedName("connections")
    @Expose
    private Connections connections;
    @SerializedName("image")
    @Expose
    private HeroImage image;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerStats getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(PowerStats powerstats) {
        this.powerstats = powerstats;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public HeroImage getImage() {
        return image;
    }

    public void setImage(HeroImage image) {
        this.image = image;
    }
}
