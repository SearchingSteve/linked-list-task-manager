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

    /**
     * Checks if the task list is empty.
     * 
     * @return true if the task list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds a new task to the end of the list.
     * 
     * @param task the task to be added.
     */
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (isEmpty()) {
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

    /**
     * Deletes the first task (head) of the list.
     * If the list is empty, it will notify the user.
     */
    public void deleteFirstTaskAdded() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        head = head.next;
        System.out.println("First task deleted.");
    }

    /**
     * Deletes the last task (tail) in the list.
     * If the list is empty, it will notify the user.
     * If there is only one task, it deletes that task.
     */
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

    /**
     * Deletes a task at the specified index.
     * If the index is invalid or out of bounds, it will notify the user.
     * 
     * @param index the index of the task to delete.
     */
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
                    System.out.println("Task " + (index + 1) + " deleted.");
                } else {
                    System.out.println("Index out of bounds. Nothing to delete.");
                }
            }
        }
    }

    /**
     * Gets the task at the specified index.
     * 
     * @param index the index of the task to retrieve.
     * @return the task at the specified index, or null if the index is out of
     *         bounds.
     */
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

    /**
     * Marks a task as completed by the specified index.
     * 
     * @param index the index of the task to mark as completed.
     */
    public void markTaskAsCompleted(int index) {
        Task task = getTaskAtIndex(index);
        if (task != null) {
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task);
        }
    }

    /**
     * Prints all tasks in the list, displaying the task number and description.
     * If the list is empty, it will notify the user.
     */
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
