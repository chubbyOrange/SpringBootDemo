package com.example.AOPDemo;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    public void watchMovies() {
        // * Auto-generated method stub
        System.out.println("Julie says: \"This movie is fantastic!\"");
    }

    public void haveDinners() {
        // * Auto-generated method stub
        System.out.println("Julie says: \"These dishes are so yummy!\"");
        // int i = 1 / 0;
    }
}
