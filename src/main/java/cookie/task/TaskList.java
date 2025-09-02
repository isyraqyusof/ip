package cookie.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> listOfTasks;

    public TaskList() {
        this.listOfTasks =  new ArrayList<>();
    }

    public TaskList(ArrayList<Task> listOfLoadedTasks) {
        this.listOfTasks = listOfLoadedTasks;
    }

    public int size() {
        return listOfTasks.size();
    }

    public Task get(int index) {
        return listOfTasks.get(index);
    }

    public void add(Task taskToBeAdded) {
        listOfTasks.add(taskToBeAdded);
    }

    public void remove(int indexOfTaskToBeRemoved) {
        listOfTasks.remove(indexOfTaskToBeRemoved);
    }
}
