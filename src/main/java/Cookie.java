import java.util.ArrayList;
import java.util.Scanner;
public class Cookie {

    private Storage storage;
    private Ui ui;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> listOfTasks;
        int taskCounter = 0;
        Storage storage = new Storage("data/cookie.txt");

        Ui ui = new Ui();

        try {
            listOfTasks = storage.load();
            taskCounter = listOfTasks.size();
        } catch (CookieException e) {
            ui.showLoadingError(e.getMessage());
            listOfTasks = new ArrayList<>();
        }

        ui.showWelcome();

        while (true) {
            String fullInput = scanner.nextLine().strip();
            String[] splitInput = fullInput.split(" ", 2);
            String firstWord = splitInput[0];

            try {
                if (fullInput.equals("bye")) {
                    ui.showBye();
                    break;
                } else if (fullInput.equals("list")) {
                    ui.showList(listOfTasks);
                } else if (firstWord.equals("mark")) {
                    if (fullInput.equals("mark")) {
                        throw new CookieException("Please specify which task you would like to mark.");
                    }
                    int indexToBeMarked = Integer.parseInt(splitInput[1]) - 1;
                    listOfTasks.get(indexToBeMarked).markAsDone();
                    ui.showMark(listOfTasks.get(indexToBeMarked));
                    storage.save(listOfTasks);
                } else if (firstWord.equals("unmark")) {
                    if (fullInput.equals("unmark")) {
                        throw new CookieException("Please specify which task you would like to unmark.");
                    }
                    int indexToBeUnmarked = Integer.parseInt(splitInput[1]) - 1;
                    listOfTasks.get(indexToBeUnmarked).markAsUndone();
                    ui.showUnmark(listOfTasks.get(indexToBeUnmarked));
                    storage.save(listOfTasks);
                } else if (firstWord.equals("delete")) {
                    if (fullInput.equals("delete")) {
                        throw new CookieException("Please specify which task you would like to delete.");
                    }
                    int indexToBeDeleted = Integer.parseInt(splitInput[1]) - 1;
                    Task taskToBeDeleted = listOfTasks.get(indexToBeDeleted);
                    listOfTasks.remove(indexToBeDeleted);
                    taskCounter--;
                    ui.showDelete(taskToBeDeleted, taskCounter);
                    storage.save(listOfTasks);
                } else if (firstWord.equals("todo")) {
                    if (fullInput.equals("todo")) {
                        throw new CookieException("Please provide a description for your todo task.");
                    }
                    Task newTodo = new Todo(splitInput[1]);
                    listOfTasks.add(newTodo);
                    taskCounter++;
                    ui.showTodo(newTodo, taskCounter);
                    storage.save(listOfTasks);
                } else if (firstWord.equals("deadline")) {
                    if (fullInput.equals("deadline") || !splitInput[1].contains("/by")) {
                        throw new CookieException("Please provide deadline in the format: {Description} /by {Day}");
                    }
                    String[] secondPhraseSplit = splitInput[1].split("/by");
                    String description = secondPhraseSplit[0];
                    String deadline = secondPhraseSplit[1];
                    Task newDeadline = new Deadline(description, deadline);
                    listOfTasks.add(newDeadline);
                    taskCounter++;
                    ui.showDeadline(newDeadline, taskCounter);
                    storage.save(listOfTasks);
                } else if (firstWord.equals("event")) {
                    if (fullInput.equals("event") || !splitInput[1].contains("/from") || !splitInput[1].contains("/to")) {
                        throw new CookieException("Please provide event in the format: {Description} /from {date/time} /to {date/time}");
                    }
                    String[] secondPhraseSplit = splitInput[1].split("/from");
                    String[] thirdPhraseSplit = secondPhraseSplit[1].split("/to");
                    String description = secondPhraseSplit[0];
                    String from = thirdPhraseSplit[0];
                    String to = thirdPhraseSplit[1];
                    Task newEvent = new Event(description, from, to);
                    listOfTasks.add(newEvent);
                    taskCounter++;
                    ui.showEvent(newEvent, taskCounter);
                    storage.save(listOfTasks);
                } else {
                    throw new CookieException("Sorry! I'm not too sure what you mean!");
                }
            } catch (CookieException e) {
                ui.showError(e.getMessage());
            }
        }
    }
}
