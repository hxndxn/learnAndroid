package com.example.recyclerviewtest;

import android.support.annotation.StringRes;

public class Fruit {
    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    private String text;
    private int image;
    public Fruit(String text,int image){
        this.text = text;
        this.image = image;
    }
}
