package ru.harmyOwner.psd.models;

public class Post {

    int id;
    String tittle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Post() {
    }

    public Post(int id, String tittle) {
        this.id = id;
        this.tittle = tittle;
    }
}
