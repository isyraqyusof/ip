package cookie.parser;

import cookie.exception.CookieException;
import cookie.storage.Storage;
import cookie.task.Deadline;
import cookie.task.Event;
import cookie.task.Task;
import cookie.task.TaskList;
import cookie.task.Todo;
import cookie.ui.Ui;

/**
 * Checks the users input matches the required format and
 * executes the relevant functions.
 */
public class Parser {

    /**
     * Checks the users input matches the required format and
     * prints the corresponding output, updates the task list,
     * and saves it.
     * Output shown in CLI.
     *
     * @param listOfTasks List of tasks currently stored.
     * @param ui The ui instance used to print relevant messages to user.
     * @param storage The storage instance used to save the current list in a text file
     * @param fullInput The complete user input string.
     * @return True if input is equal to "bye", false otherwise.
     * @throws CookieException If input does not follow required format.
     */
    public static boolean isParsing(
            TaskList listOfTasks, Ui ui, Storage storage, String fullInput) throws CookieException {

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
                    throw new CookieException(
                            "Please provide event in the format: {Description} /from {date/time} /to {date/time}");
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
            } else if (firstWord.equals("find")) {
                if (fullInput.equals("find")) {
                    throw new CookieException("Please specify task to find.");
                }
                String taskToFind = splitInput[1];
                System.out.println(taskToFind);
                TaskList listOfMatchingTasks = listOfTasks.find(taskToFind);
                ui.showFindings(listOfMatchingTasks);
            } else {
                throw new CookieException("Sorry! I'm not too sure what you mean!");
            }
        } catch (CookieException e) {
            ui.showError(e.getMessage());
        }
        return true;
    }

    /**
     * Checks the users input matches the required format and
     * prints the corresponding output, updates the task list,
     * and saves it.
     * Output shown in GUI.
     *
     * @param listOfTasks List of tasks currently stored.
     * @param ui The ui instance used to print relevant messages to user.
     * @param storage The storage instance used to save the current list in a text file
     * @param fullInput The complete user input string.
     * @return True if input is equal to "bye", false otherwise.
     * @throws CookieException If input does not follow required format.
     */
    public static String parseForGui(
            TaskList listOfTasks, Ui ui, Storage storage, String fullInput) throws CookieException {

        String[] splitInput = fullInput.split(" ", 2);
        String firstWord = splitInput[0];
        try {
            if (fullInput.equals("bye")) {
                return ui.showByeGui();
            } else if (fullInput.equals("list")) {
                return ui.showListGui(listOfTasks);
            } else if (firstWord.equals("mark")) {
                if (fullInput.equals("mark")) {
                    throw new CookieException("Please specify which task you would like to mark.");
                }
                int indexToBeMarked = Integer.parseInt(splitInput[1]) - 1;
                listOfTasks.get(indexToBeMarked).markAsDone();
                storage.save(listOfTasks);
                return ui.showMarkGui(listOfTasks.get(indexToBeMarked));
            } else if (firstWord.equals("unmark")) {
                if (fullInput.equals("unmark")) {
                    throw new CookieException("Please specify which task you would like to unmark.");
                }
                int indexToBeUnmarked = Integer.parseInt(splitInput[1]) - 1;
                listOfTasks.get(indexToBeUnmarked).markAsUndone();
                storage.save(listOfTasks);
                return ui.showUnmarkGui(listOfTasks.get(indexToBeUnmarked));
            } else if (firstWord.equals("delete")) {
                if (fullInput.equals("delete")) {
                    throw new CookieException("Please specify which task you would like to delete.");
                }
                int indexToBeDeleted = Integer.parseInt(splitInput[1]) - 1;
                Task taskToBeDeleted = listOfTasks.get(indexToBeDeleted);
                listOfTasks.remove(indexToBeDeleted);
                storage.save(listOfTasks);
                return ui.showDeleteGui(taskToBeDeleted, listOfTasks.size());
            } else if (firstWord.equals("todo")) {
                if (fullInput.equals("todo")) {
                    throw new CookieException("Please provide a description for your todo task.");
                }
                assert splitInput.length == 2 : "Todo task should have a type and description";
                Task newTodo = new Todo(splitInput[1]);
                listOfTasks.add(newTodo);
                storage.save(listOfTasks);
                return ui.showTodoGui(newTodo, listOfTasks.size());
            } else if (firstWord.equals("deadline")) {
                if (fullInput.equals("deadline") || !splitInput[1].contains("/by")) {
                    throw new CookieException("Please provide deadline in the format: {Description} /by {Day}");
                }
                String[] secondPhraseSplit = splitInput[1].split("/by");
                assert secondPhraseSplit.length == 2 : "Deadline task should have a description and end date/time";
                String description = secondPhraseSplit[0];
                String deadline = secondPhraseSplit[1];
                Task newDeadline = new Deadline(description, deadline);
                listOfTasks.add(newDeadline);
                storage.save(listOfTasks);
                return ui.showDeadlineGui(newDeadline, listOfTasks.size());
            } else if (firstWord.equals("event")) {
                if (fullInput.equals("event") || !splitInput[1].contains("/from") || !splitInput[1].contains("/to")) {
                    throw new CookieException(
                            "Please provide event in the format: {Description} /from {date/time} /to {date/time}");
                }
                String[] secondPhraseSplit = splitInput[1].split("/from");
                String[] thirdPhraseSplit = secondPhraseSplit[1].split("/to");
                String description = secondPhraseSplit[0];
                assert thirdPhraseSplit.length == 2 : "Event task should have a start and end date/time";
                String from = thirdPhraseSplit[0];
                String to = thirdPhraseSplit[1];
                Task newEvent = new Event(description, from, to);
                listOfTasks.add(newEvent);
                storage.save(listOfTasks);
                return ui.showEventGui(newEvent, listOfTasks.size());
            } else if (firstWord.equals("find")) {
                if (fullInput.equals("find")) {
                    throw new CookieException("Please specify task to find.");
                }
                String taskToFind = splitInput[1];
                System.out.println(taskToFind);
                TaskList listOfMatchingTasks = listOfTasks.find(taskToFind);
                return ui.showFindingsGui(listOfMatchingTasks);
            } else {
                throw new CookieException("Sorry! I'm not too sure what you mean!");
            }
        } catch (CookieException e) {
            ui.showError(e.getMessage());
        }
        return "Try again.";
    }
}
