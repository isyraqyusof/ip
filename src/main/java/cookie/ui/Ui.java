package cookie.ui;

import java.util.Scanner;

import cookie.task.Task;
import cookie.task.TaskList;


/**
 * Handles input and output operations and displaying of relevant messages.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);
    private final String line = "___________________________________";

    public Ui() {

    }

    /**
     * Displays welcome message when user first launches the application.
     */
    public void showWelcome() {
        System.out.println(line);
        System.out.println("Hey there! My name is Cookie");
        System.out.println("How can I help you?");
        System.out.println(line);
    }

    /**
     * Displays a line.
     */
    public void showLine() {
        System.out.println(line);
    }

    /**
     * Displays goodbye message when the application is terminated.
     */
    public void showBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    /**
     * Displays all the tasks in the current list of tasks.
     *
     * @param listOfTasks Current list of tasks.
     */
    public void showList(TaskList listOfTasks) {
        System.out.println(line);
        System.out.println("Here are your tasks:");
        for (int i = 0; i < listOfTasks.size(); i++) {
            System.out.println((i + 1) + ". " + listOfTasks.get(i));
        }
    }

    /**
     * Displays message indicating the task has been marked as done.
     */
    public void showMark(Task taskToBeMarked) {
        System.out.println(line);
        System.out.println("Great! I've marked this task as done:");
        System.out.println(taskToBeMarked);
    }

    /**
     * Displays message indicating the task has been marked as not done.
     */
    public void showUnmark(Task taskToBeUnmarked) {
        System.out.println(line);
        System.out.println("Alright. I've marked this task as not done yet:");
        System.out.println(taskToBeUnmarked);
    }

    /**
     * Displays message indicating the task has been deleted from the list of tasks.
     *
     * @param taskToBeDeleted The task to delete.
     * @param taskCounter Number of tasks in the list after deletion.
     */
    public void showDelete(Task taskToBeDeleted, int taskCounter) {
        System.out.println(line);
        System.out.println("Alright. I've deleted this task:");
        System.out.println(taskToBeDeleted);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    /**
     * Displays message indicating the todo task has been added to the list of tasks.
     *
     * @param newTodo Todo task to added.
     * @param taskCounter Number of tasks in the list after adding new todo.
     */
    public void showTodo(Task newTodo, int taskCounter) {
        System.out.println(line);
        System.out.println("A todo, got it! I've added this task:");
        System.out.println(newTodo);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    /**
     * Displays message indicating the deadline task has been added to the list of tasks.
     *
     * @param newDeadline Deadline task to added.
     * @param taskCounter Number of tasks in the list after adding new deadline task.
     */
    public void showDeadline(Task newDeadline, int taskCounter) {
        System.out.println(line);
        System.out.println("A deadline, got it! I've added this task:");
        System.out.println(newDeadline);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    /**
     * Displays message indicating the event task has been added to the list of tasks.
     *
     * @param newEvent Event task to added.
     * @param taskCounter Number of tasks in the list after adding new event task.
     */
    public void showEvent(Task newEvent, int taskCounter) {
        System.out.println(line);
        System.out.println("An event, got it! I've added this task:");
        System.out.println(newEvent);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    /**
     * Displays error message to user.
     *
     * @param message Error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(line);
        System.out.println("Oh no! " + message);
    }

    /**
     * Displays message indicating an error in loading of tasks.
     */
    public void showLoadingError() {
        System.out.println(line);
        System.out.println("Error in loading tasks.");
    }

    /**
     * Reads next line of user input.
     *
     * @return User input as a String without leading and trailing whitespace.
     */
    public String readNextLine() {
        return scanner.nextLine().strip();
    }

    /**
     * Displays the list of matching tasks.
     *
     * @param listOfMatchingTasks List of matching tasks.
     */
    public void showFindings(TaskList listOfMatchingTasks) {
        System.out.println(line);
        int numberOfMatchingTasks = listOfMatchingTasks.size();
        if (numberOfMatchingTasks == 0) {
            System.out.println("No matching tasks!");
        } else {
            System.out.println("Here are the tasks that match!");
            for (int i = 0; i < listOfMatchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + listOfMatchingTasks.get(i));
            }
        }
    }
}
