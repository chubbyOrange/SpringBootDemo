package com.example.DynamicProxyDemo.JDK;

public class Julie implements Girl {

    @Override
    public void watchMovies(String adj) {
        // * Auto-generated method stub
        System.out.println("Julie says: \"This movie is " + adj + "!\"");
    }

    @Override
    public String haveDinners(String adj) {
        // * Auto-generated method stub
        System.out.println("Julie says: \"These dishes are " + adj + "!\"");
        return "";
    }

}
