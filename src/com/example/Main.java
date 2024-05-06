package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // static list of users, acting as db
    private static ArrayList<User> users =new ArrayList<>();

    // mock auth service that always returns the first user when log in, and does nothing when sign up
//    private static IAuthenticationService authService = new IAuthenticationService() {
//        @Override
//        public User signUp(String username, String password){
//            return null;
//        }
//
//        @Override
//        public User logIn(String username, String password){
//            return users.get(0);
//        }
//    };

    private static IAuthenticationService authService = new AuthenticationService();

    private static boolean isRunning = true;


    public static void main(String[] args) {
        users.add(new User("test", "test"));
        while(isRunning){
            showMenu();
        }
    }

    public static void showMenu(){
        System.out.println("Welcome");
        System.out.println("1. Log In");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    public static void handleMenu(int choice) {
        switch(choice) {
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    public static void onExit() {
        isRunning = false;
    }

    public static void onLogIn() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        if(user != null) {
            System.out.println(user);
        } else {
            System.out.println("User does not exist!");
        }
        // Add the to-do list operations
        ToDoList toDoList = new ToDoList(user);
        toDoList.run();
    }

    public static void onSignUp() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user= authService.signUp(username, password);
        if(user != null) {
            System.out.println("User " + user.getUsername() + " has been created successfully!");
        } else {
            System.out.println("The username is already taken");
        }
    }
}