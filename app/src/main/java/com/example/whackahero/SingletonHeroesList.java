package com.example.whackahero;

import java.util.Set;

public class SingletonHeroesList {

    private static SingletonHeroesList instance;
    private Set<Hero> heroesList;

    private SingletonHeroesList() {
    }

    public static SingletonHeroesList getInstance() {
        if (instance == null) {
            instance = new SingletonHeroesList();
        }
        return instance;
    }

    public Set<Hero> getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(Set<Hero> heroesList) {
        this.heroesList = heroesList;
    }

}
