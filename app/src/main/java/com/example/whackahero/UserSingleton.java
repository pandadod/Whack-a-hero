package com.example.whackahero;

import java.util.List;

public class UserSingleton {

    private static UserSingleton instance;
    private User user;

    private UserSingleton() {
    }

    public static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void initiateUser(Long idUser, String login, String password, int scoreMax) {
        user = new User(idUser, login, password, scoreMax);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
