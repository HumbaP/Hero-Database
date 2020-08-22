package com.example.herodatabase.connections.requests;

import com.example.herodatabase.models.SuperHero;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeroAPIResponse {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("results-for")
    @Expose
    private String resultsFor;
    @SerializedName("results")
    @Expose
    private List<SuperHero> results = null;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResultsFor() {
        return resultsFor;
    }

    public void setResultsFor(String resultsFor) {
        this.resultsFor = resultsFor;
    }

    public List<SuperHero> getResults() {
        return results;
    }

    public void setResults(List<SuperHero> results) {
        this.results = results;
    }
}
