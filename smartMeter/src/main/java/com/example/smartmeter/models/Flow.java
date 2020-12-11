package com.example.smartmeter.models;

public class Flow {
    int id;
    String source;
    String destination;
    String libelle;
    String frequency;

    public Flow(int id, String source, String destination, String libelle, String frequency) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.libelle = libelle;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", libelle='" + libelle + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
