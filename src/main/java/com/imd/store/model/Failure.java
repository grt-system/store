package com.imd.store.model;

public class Failure {
    private String type;
    private double probability;
    private long duration;


    public Failure(String type, double probability, long duration) {
        this.type = type;
        this.probability = probability;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
