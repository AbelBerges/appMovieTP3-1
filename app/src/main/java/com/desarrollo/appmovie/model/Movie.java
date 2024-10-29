package com.desarrollo.appmovie.model;

public class Movie {
    private String title, cover;
    private float estrellas;
    public Movie(String title,String cover,float estrellas){
        this.title = title;
        this.cover = cover;
        this.estrellas = estrellas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }
}
