package cookie.parser;

import cookie.exception.CookieException;
import cookie.ui.Ui;
import cookie.storage.Storage;
import cookie.task.Deadline;
import cookie.task.Event;
import cookie.task.Task;
import cookie.task.TaskList;
import cookie.task.Todo;

public class Parser {

    public static boolean parse(TaskList listOfTasks, Ui ui, Storage storage, String fullInput) throws CookieException {

        String[] splitInput = fullInput.split(" ", 2);
        String firstWord = splitInput[0];
        try {
            if (fullInput.equals("bye")) {
                ui.showBye();
                return false;
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
                ui.showDelete(taskToBeDeleted, listOfTasks.size());
                storage.save(listOfTasks);
            } else if (firstWord.equals("todo")) {
                if (fullInput.equals("todo")) {
                    throw new CookieException("Please provide a description for your todo task.");
                }
                Task newTodo = new Todo(splitInput[1]);
                listOfTasks.add(newTodo);
                ui.showTodo(newTodo, listOfTasks.size());
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
                ui.showDeadline(newDeadline, listOfTasks.size());
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
                ui.showEvent(newEvent, listOfTasks.size());
                storage.save(listOfTasks);
            } else {
                throw new CookieException("Sorry! I'm not too sure what you mean!");
            }
        } catch (CookieException e) {
            ui.showError(e.getMessage());
        }
        return true;
    }
}
