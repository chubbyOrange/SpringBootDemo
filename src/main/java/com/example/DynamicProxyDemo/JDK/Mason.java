package com.example.DynamicProxyDemo.JDK;

public class Mason {
    public static void main(String[] args) {
        Julie julie = new Julie();
        JulieProxy family = new JulieProxy(julie);
        Girl mother = (Girl) family.getProxyInstance();

        mother.watchMovies("fantastic");

        System.out.println("-----------------------");

        String followingWords = mother.haveDinners("so yummy");
        System.out.println(followingWords);
    }
}
