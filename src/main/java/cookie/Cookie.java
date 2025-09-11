package cookie;

import cookie.exception.CookieException;
import cookie.parser.Parser;
import cookie.storage.Storage;
import cookie.task.TaskList;
import cookie.ui.Ui;

/**
 * cookie.ui.Main class for the Cookie task management chatbot.
 * Handles interaction between the UI, Storage, Parser and Tasks.
 */
public class Cookie {

    private Storage storage;
    private TaskList listOfTasks;
    private Ui ui;

    /**
     * Constructs new instance of Cookie application.
     * Initializes Ui and Storage and loads tasks from saved file.
     *
     * @param filePath Path of file to load tasks from.
     */
    public Cookie(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            listOfTasks = new TaskList(storage.load());
        } catch (CookieException e) {
            ui.showLoadingError();
            listOfTasks = new TaskList();
        }
    }

    /**
     * Displays welcome message.
     * Runs the main loop to run the Cookie chatbot.
     * Process user commands and handles program termination.
     */
    public void run() {
        ui.showWelcome();
        boolean isRunning = true;
        while (isRunning) {
            try {
                ui.showLine();
                isRunning = Parser.isParsing(listOfTasks, ui, storage, ui.readNextLine());
            } catch (CookieException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Calls the function to start the main program loop.
     * @param args
     */
    public static void main(String[] args) {
        new Cookie("data/cookie.txt").run();
    }

    public String getResponse(String input) {
        try {
            return Parser.parseForGui(listOfTasks, ui, storage, input);
        } catch (CookieException e) {
            return ui.showErrorGui(e.getMessage());
        }
    }
}
