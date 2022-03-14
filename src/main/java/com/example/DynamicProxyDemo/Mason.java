package com.example.DynamicProxyDemo;

public class Mason {
    public static void main(String[] args) {
        Girl girl = new Julie();
        JulieProxy family = new JulieProxy(girl);
        Girl mother = (Girl) family.getProxyInstance();
        mother.watchMovies();
        System.out.println("-----------------------");
        mother.haveDinners();
    }
}
