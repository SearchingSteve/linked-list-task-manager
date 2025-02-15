package edu.keyin.stephencrocker;

public class User {
    private String name;
    private TaskList taskList;

    public User(String name, TaskList taskList) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
        // Use as method is main menu to copy users task list
    }


    private void addTask(Task task){

    }

    private void markTaskComplete(int index){
        taskList.markTaskAsCompleted(index);
    }

    private void printTasks(){
        System.out.println(name + "'s" + "tasks: ");
        taskList.printTasks();

    }
}
