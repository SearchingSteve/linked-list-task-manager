package edu.keyin.stephencrocker;

public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return description + " - " + (isCompleted ? "Completed" : "Not Completed");
    }
}
