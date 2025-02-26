# Task Manager Application

A simple console-based task management system implemented in Java that allows users to create user profiles and manage their tasks.

This application uses a custom-built singly linked list (SLL) data structure to store and manage tasks

## Features

- **User Management**: Create and view users in the system
- **Task Management**: Add, delete, and mark tasks as completed
- **Task Viewing**: View tasks for a specific user or all users

## System Requirements

- Java Development Kit (JDK) 15 or higher
- Any operating system that supports Java

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/task-manager.git
   ```
2. Navigate to the project directory:
   ```
   cd task-manager
   ```
3. Compile the Java files:
   ```
   javac edu/keyin/stephencrocker/*.java
   ```
4. Run the application:
   ```
   java edu.keyin.stephencrocker.Main
   ```


## Usage
The application presents a menu-driven interface with the following options:
1. **Create User**: Add a new user to the system
   - Prompts for a username
   - Checks if the username already exists
   - Enforces the maximum user limit 
   - Confirms when a user is successfully created
2. **Add Task**: Create a new task for a specific user
   - Prompts for username selection
   - Requests task description
   - Adds the task to the selected user's task list
3. **Delete Task**: Remove a task from a user's list
   - Prompts for username selection
   - Checks if the user has any tasks to delete
   - Requests the task number to delete
   - Removes the specified task from the linked list
4. **Mark Task as Completed**: Update a task's status
   - Prompts for username selection
   - Checks if the user has any tasks to mark
   - Requests the task number to mark as completed
   - Updates the task status in the system
5. **View a User's Tasks**: Display all tasks for a selected user
   - Prompts for username selection
   - Displays all tasks for that user with their completion status
6. **View All Users' Tasks**: Display tasks for all users in the system
   - Shows a list of all tasks by all users organized by user
   - Includes completion status for each task
7. **View Users**: List all users in the system
   - Displays all registered usernames
   - Indicates if no users have been created yet
8. **Exit**: Close the application
   - Properly closes the scanner
   - Terminates the program



## Project Structure

The application is organized into several key classes:
- `Main`: Contains the application logic and user interface
- `User`: Represents a user in the system
- `Task`: Represents an individual task
- `TaskList`: Manages collections of tasks (SLL)

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b new-feature`
3. Commit your changes: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin new-feature`
5. Submit a pull request

### License

This project is licensed for educational purposes only. Redistribution, modification, or commercial use requires prior written permission.

### Author

- **Stephen Crocker**
- GitHub: [SearchingSteve](https://github.com/SearchingSteve)
