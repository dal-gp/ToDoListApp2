package com.example;

import java.util.Scanner;
import java.util.Iterator;

public class ToDoList {
    private User user;
    private boolean isRunning;

    public ToDoList(User user) {
        this.user = user;
        isRunning = true;
    }

    public void run() {
        while(isRunning) {
            showMenu();
        }
    }

    public void showMenu(){
        System.out.println("1. Show all items");
        System.out.println("2. Add item");
        System.out.println("3. Mark item as done");
        System.out.println("4. Mark item as undone");
        System.out.println("5. Delete an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    public void handleMenu(int choice) {
        switch(choice) {
            case 1:
                onShowAllItems();
                break;
            case 2:
                onAddItem();
                break;
            case 3:
                onMarkAsDone();
                break;
            case 4:
                onMarkAsUnDone();
                break;
            case 5:
                onDeleteItem();
                break;
            case 6:
                onExit();
                break;
            default:
                System.out.println("Invalid choice");
                showMenu();
        }
    }

    public void onShowAllItems() {
        int j = 0;
        Iterator<ToDoItem> i = user.getToToDoItems().iterator();
        while(i.hasNext()){
            ToDoItem item = i.next();
            if(item.isDone()) {
                System.out.println((j++) + ". [X] " + item.getDescription());
            } else {
                System.out.println((j++) + ". [ ] " + item.getDescription());
            }
        }
    }

    public void onAddItem() {
        System.out.println("Enter the description of the item: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        user.getToToDoItems().add(new ToDoItem(description));
        System.out.println("Item added.");
    }

    public void onMarkAsDone() {
        onShowAllItems();
        System.out.println("Enter the number of the item to mark as done: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        ToDoItem item = user.getToToDoItems().get(itemNumber);
        item.setDone(true);
    }

    public void onMarkAsUnDone() {
        onShowAllItems();
        System.out.println("Enter the number of the item to mark as undone: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        ToDoItem item = user.getToToDoItems().get(itemNumber);
        item.setDone(false);
    }

    public void onDeleteItem() {
        onShowAllItems();
        System.out.println("Enter the number of the item to delete: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        user.getToToDoItems().remove(itemNumber);
    }

    public void onExit(){
        isRunning = false;
    }


}
