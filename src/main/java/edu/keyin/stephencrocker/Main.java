package edu.keyin.stephencrocker;

import java.util.Scanner;

public class Main {
    private static final int MAX_USERS = 5;
    private static final User[] users = new User[MAX_USERS];
    private static int userCount = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> addTask();
                case 3 -> markTaskCompleted();
                case 4 -> viewTasks();
                case 5 -> exitProgram();
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n1. Create User");
        System.out.println("2. Add Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. View Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        return choice;
    }

    private static void createUser() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine().trim();

        if (findUser(userName) != null) {
            System.out.println("User already exists.");
            return;
        }

        if (userCount < MAX_USERS) {
            users[userCount++] = new User(userName);
            System.out.println("User created: " + userName);
        } else {
            System.out.println("User limit reached.");
        }
    }

    private static void addTask() {
        User user = getUser();
        if (user == null) return;

        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine().trim();
        user.getTaskList().addTask(new Task(taskDescription));
    }

    private static void markTaskCompleted() {
        User user = getUser();
        if (user == null) return;

        System.out.print("Enter task number to mark as completed: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            return;
        }
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); 

        user.getTaskList().markTaskAsCompleted(taskNumber - 1);
    }

    private static void viewTasks() {
        User user = getUser();
        if (user == null) return;

        user.printTasks();
    }

    private static User getUser() {
        if (userCount == 0) {
            System.out.println("No users in system. Create a user first.");
            return null;
        }

        System.out.print("Enter user name: ");
        String userName = scanner.nextLine().trim();
        User user = findUser(userName);

        if (user == null) {
            System.out.println("User not found.");
        }
        return user;
    }

    private static User findUser(String userName) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(userName)) {
                return users[i];
            }
        }
        return null;
    }

    private static void exitProgram() {
        System.out.println("Exiting program...");
        scanner.close();
        System.exit(0);
    }
}
