package com.example;

public interface IAuthenticationService {
    User logIn(String username, String password);
    User signUp(String username, String password);
}
