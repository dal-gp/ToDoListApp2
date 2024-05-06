package com.example;

import java.util.ArrayList;
import java.util.Iterator;

public class AuthenticationService implements IAuthenticationService{
    private ArrayList<User> users;

    public AuthenticationService() {
        users = new ArrayList<>();
        users.add(new User("t", "p"));
    }
    @Override
    public User logIn(String username, String password) {
        Iterator<User> i =  users.iterator();
        while(i.hasNext()) {
            User user = i.next();
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User signUp(String username, String password) {
        Iterator i = users.iterator();
        while(i.hasNext()){
            User existsAlready = (User) i.next();
            if(existsAlready.getUsername().equals(username)){
                return null;
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }
}
