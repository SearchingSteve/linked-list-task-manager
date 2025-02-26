package edu.keyin.stephencrocker;

import java.util.Scanner;

/**
 * Main class for managing user tasks in a simple task management system.
 */
public class Main {
    private static final int MAX_USERS = 5;
    private static final User[] users = new User[MAX_USERS];
    private static int userCount = 0;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The entry point for the program that runs a continuous loop showing the menu.
     */
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> addTask();
                case 3 -> deleteTask();
                case 4 -> markTaskCompleted();
                case 5 -> viewUserTasks();
                case 6 -> viewAllUsersTasks();
                case 7 -> viewUsers();
                case 8 -> exitProgram();
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Displays the main menu of options for the user to choose from.
     */
    private static void displayMenu() {
        System.out.println("\n1. Create User");
        System.out.println("2. Add Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. View a User's Tasks");
        System.out.println("6. View All Users' Tasks");
        System.out.println("7. View Users");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Reads and returns the user's choice of menu option.
     * 
     * @return the chosen menu option.
     */
    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    /**
     * Creates a new user with the provided username. If the user already exists or
     * the
     * user limit is reached, it will notify the user.
     */
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
            System.out.println("User limit reached. (Max = " + MAX_USERS + ")");
        }
    }

    /**
     * Adds a new task for the specified user. The user is prompted to enter a task
     * description.
     */
    private static void addTask() {
        User user = getUser();
        if (user == null)
            return;

        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine().trim();
        user.getTaskList().addTask(new Task(taskDescription));
    }

    /**
     * Deletes a task from the specified user. The user is prompted to enter a task
     * number
     * to delete.
     */
    private static void deleteTask() {
        User user = getUser();
        if (user == null)
            return;
        if (user.getTaskList().isEmpty()) {
            System.out.println("This user has no tasks to delete.");
            return;
        }
        System.out.print("Enter task number to delete: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            return;
        }
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        user.getTaskList().deleteTaskAtIndex(taskNumber - 1);
    }

    /**
     * Marks a task as completed for the specified user. The user is prompted to
     * enter
     * a task number to mark as completed.
     */
    private static void markTaskCompleted() {
        User user = getUser();
        if (user == null)
            return;

        if (user.getTaskList().isEmpty()) {
            System.out.println("This user has no tasks to mark as completed.");
            return;
        }
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

    /**
     * Displays the tasks of a specific user.
     */
    private static void viewUserTasks() {
        User user = getUser();
        if (user == null)
            return;

        user.printTasks();
    }

    /**
     * Displays all users in the system.
     */
    public static void viewUsers() {
        if (userCount == 0) {
            System.out.println("No users in system. Create a user first.");
            return;
        }
        System.out.println("\nUsers in system: ");
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i].getName());
        }
    }

    /**
     * Displays all tasks for all users in the system.
     */
    public static void viewAllUsersTasks() {
        if (userCount == 0) {
            System.out.println("No users in system. Create a user first.");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            users[i].printTasks();
        }
    }

    /**
     * Prompts the user for a username and returns the corresponding user object.
     * 
     * @return the user object, or null if the user is not found.
     */
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

    /**
     * Searches for a user by their username.
     * 
     * @param userName the username to search for.
     * @return the user if found, or null if not found.
     */
    private static User findUser(String userName) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(userName)) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * Exits the program, closing the scanner and terminating the application.
     */
    private static void exitProgram() {
        System.out.println("Exiting program...");
        scanner.close();
        System.exit(0);
    }
}
