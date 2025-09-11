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
     * Displays welcome message when user first launches the application in CLI.
     */
    public void showWelcome() {
        System.out.println(line);
        System.out.println("Hey there! My name is Cookie");
        System.out.println("How can I help you?");
        System.out.println(line);
    }

    /**
     * Displays welcome message when user first launches the application in GUI.
     */
    public String showWelcomeGui() {
        return "Hey there! My name is Cookie\n How can I help you?";
    }

    /**
     * Displays a line.
     */
    public void showLine() {
        System.out.println(line);
    }

    /**
     * Displays goodbye message when the application is terminated in CLI.
     */
    public void showBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    /**
     * Displays goodbye message when the application is terminated in GUI.
     */
    public String showByeGui() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Displays all the tasks in the current list of tasks in CLI.
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
     * Displays all the tasks in the current list of tasks in GUI.
     *
     * @param listOfTasks Current list of tasks.
     */
    public String showListGui(TaskList listOfTasks) {
        String output = "Here are your tasks:\n";
        for (int i = 0; i < listOfTasks.size(); i++) {
            output += ((i + 1) + ". " + listOfTasks.get(i) + "\n");
        }
        return output;
    }

    /**
     * Displays message indicating the task has been marked as done for CLI.
     */
    public void showMark(Task taskToBeMarked) {
        System.out.println(line);
        System.out.println("Great! I've marked this task as done:");
        System.out.println(taskToBeMarked);
    }

    /**
     * Displays message indicating the task has been marked as done for GUI.
     */
    public String showMarkGui(Task taskToBeMarked) {
        return "Great! I've marked this task as done:\n" + taskToBeMarked;
    }

    /**
     * Displays message indicating the task has been marked as not done for CLI.
     */
    public void showUnmark(Task taskToBeUnmarked) {
        System.out.println(line);
        System.out.println("Alright. I've marked this task as not done yet:");
        System.out.println(taskToBeUnmarked);
    }

    /**
     * Displays message indicating the task has been marked as not done for GUI.
     */
    public String showUnmarkGui(Task taskToBeUnmarked) {
        return "Alright. I've marked this task as not done yet:\n" + taskToBeUnmarked;
    }

    /**
     * Displays message indicating the task has been deleted from the list of tasks for CLI.
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
     * Displays message indicating the task has been deleted from the list of tasks for GUI.
     *
     * @param taskToBeDeleted The task to delete.
     * @param taskCounter Number of tasks in the list after deletion.
     */
    public String showDeleteGui(Task taskToBeDeleted, int taskCounter) {

        return "Alright. I've deleted this task:\n" + taskToBeDeleted
                + "\n" + "Now you have " + taskCounter + " tasks in the list.";
    }

    /**
     * Displays message indicating the todo task has been added to the list of tasks for CLI.
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
     * Displays message indicating the todo task has been added to the list of tasks for GUI.
     *
     * @param newTodo Todo task to added.
     * @param taskCounter Number of tasks in the list after adding new todo.
     */
    public String showTodoGui(Task newTodo, int taskCounter) {

        return "A todo, got it! I've added this task:\n" + newTodo + "\n"
                + "Now you have " + taskCounter + " tasks in the list.";
    }

    /**
     * Displays message indicating the deadline task has been added to the list of tasks for CLI.
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
     * Displays message indicating the deadline task has been added to the list of tasks for GUI.
     *
     * @param newDeadline Deadline task to added.
     * @param taskCounter Number of tasks in the list after adding new deadline task.
     */
    public String showDeadlineGui(Task newDeadline, int taskCounter) {
        return "A deadline, got it! I've added this task:\n" + newDeadline + "\n"
                + "Now you have " + taskCounter + " tasks in the list.";
    }

    /**
     * Displays message indicating the event task has been added to the list of tasks for CLI.
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
     * Displays message indicating the event task has been added to the list of tasks for GUI.
     *
     * @param newEvent Event task to added.
     * @param taskCounter Number of tasks in the list after adding new event task.
     */
    public String showEventGui(Task newEvent, int taskCounter) {
        return "An event, got it! I've added this task:\n" + newEvent + "\n"
                + "Now you have " + taskCounter + " tasks in the list.";
    }

    /**
     * Displays error message to user for CLI.
     *
     * @param message Error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(line);
        System.out.println("Oh no! " + message);
    }

    /**
     * Displays error message to user for GUI.
     *
     * @param message Error message to be displayed.
     */
    public String showErrorGui(String message) {
        return "Oh no! " + message;
    }

    /**
     * Displays message indicating an error in loading of tasks for CLI.
     */
    public void showLoadingError() {
        System.out.println(line);
        System.out.println("Error in loading tasks.");
    }

    /**
     * Displays message indicating an error in loading of tasks for GUI.
     */
    public String showLoadingErrorGui() {
        return "Error in loading tasks.";
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
     * Displays the list of matching tasks for CLI.
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

    /**
     * Displays the list of matching tasks for GUI.
     *
     * @param listOfMatchingTasks List of matching tasks.
     */
    public String showFindingsGui(TaskList listOfMatchingTasks) {
        int numberOfMatchingTasks = listOfMatchingTasks.size();
        if (numberOfMatchingTasks == 0) {
            return "No matching tasks!";
        } else {
            String output = "Here are the tasks that match!";
            for (int i = 0; i < listOfMatchingTasks.size(); i++) {
                output += ((i + 1) + ". " + listOfMatchingTasks.get(i) + "\n");
            }
            return output;
        }
    }
}
