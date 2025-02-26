package edu.keyin.stephencrocker;

// Represents the to-do list for a user.
// Includes methods to add a task, delete tasks, mark a task as completed, and print all tasks.

public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskList() {
        this.head = null;
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Task added: " + task);
    }

    // Delete the first task (head) of the list
    public void deleteFirstTaskAdded() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        head = head.next;
        System.out.println("First task deleted.");
    }

    // Delete the last task in the list
    public void deleteLastTaskAdded() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            head = null;
            System.out.println("Last task deleted.");
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        System.out.println("Last task deleted.");
    }

    // Delete a task at the specified index
    public void deleteTaskAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        Task task = getTaskAtIndex(index);
        if (task != null) {
            if (index == 0) {
                deleteFirstTaskAdded();
            } else {
                Node curr = head;
                int i = 0;
                while (curr != null && i < index - 1) {
                    curr = curr.next;
                    i++;
                }
                if (curr != null && curr.next != null) {
                    curr.next = curr.next.next;
                    System.out.println("Task deleted at index " + index);
                } else {
                    System.out.println("Index out of bounds. Nothing to delete.");
                }
            }
        }
    }

    // Get the task at the specified index
    public Task getTaskAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty. Nothing to show.");
            return null;
        }

        Node curr = head;
        int i = 0;

        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }

        if (curr == null) {
            System.out.println("Index out of bounds. No task found at index " + index);
            return null;
        } else {
            return curr.task;
        }
    }

    // Mark a task as completed by index
    public void markTaskAsCompleted(int index) {
        Task task = getTaskAtIndex(index);
        if (task != null) {
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task);
        }
    }

    // Print all tasks in the list
    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Node curr = head;
        int taskCount = 0;
        while (curr != null) {
            taskCount++;
            System.out.println(taskCount + ". " + curr.task);
            curr = curr.next;
        }
    }
}
