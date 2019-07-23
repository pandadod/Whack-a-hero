package com.example.whackahero;

public class User {

    private Long id;
    private String name;
    private String password;
    private int scoreMax;

    public User() {
    }

    public User(Long id, String name, String password, int scoreMax) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.scoreMax = scoreMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }
}
