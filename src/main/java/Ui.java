import java.util.ArrayList;

public class Ui {
    private final String line = "___________________________________";

    public Ui() {

    }

    public void showWelcome() {
        System.out.println(line);
        System.out.println("Hey there! My name is Cookie");
        System.out.println("How can I help you?");
        System.out.println(line);
    }

    public void showLine() {
        System.out.println(line);
    }

    public void showBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    public void showList(TaskList listOfTasks) {
        System.out.println(line);
        System.out.println("Here are your tasks:");
        for (int i = 0; i < listOfTasks.size(); i++) {
            System.out.println((i + 1) + ". " + listOfTasks.get(i));
        }
        System.out.println(line);
    }

    public void showMark(Task taskToBeMarked) {
        System.out.println(line);
        System.out.println("Great! I've marked this task as done:");
        System.out.println(taskToBeMarked);
        System.out.println(line);
    }

    public void showUnmark(Task taskToBeUnmarked) {
        System.out.println(line);
        System.out.println("Alright. I've marked this task as not done yet:");
        System.out.println(taskToBeUnmarked);
        System.out.println(line);
    }

    public void showDelete(Task taskToBeDeleted, int taskCounter) {
        System.out.println(line);
        System.out.println("Alright. I've deleted this task:");
        System.out.println(taskToBeDeleted);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
        System.out.println(line);
    }

    public void showTodo(Task newTodo, int taskCounter) {
        System.out.println(line);
        System.out.println("A todo, got it! I've added this task:");
        System.out.println(newTodo);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
        System.out.println(line);
    }

    public void showDeadline(Task newDeadline, int taskCounter) {
        System.out.println(line);
        System.out.println("A deadline, got it! I've added this task:");
        System.out.println(newDeadline);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
        System.out.println(line);
    }

    public void showEvent(Task newEvent, int taskCounter) {
        System.out.println(line);
        System.out.println("An event, got it! I've added this task:");
        System.out.println(newEvent);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
        System.out.println(line);
    }

    public void showError(String message) {
        System.out.println(line);
        System.out.println("Oh no! " + message);
        System.out.println(line);
    }

    public void showLoadingError(String message) {
        System.out.println("Error in loading tasks." + message);
    }

}
