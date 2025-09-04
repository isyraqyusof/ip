package cookie;

import cookie.exception.CookieException;
import cookie.parser.Parser;
import cookie.storage.Storage;
import cookie.task.TaskList;
import cookie.ui.Ui;

public class Cookie {

    private Storage storage;
    private TaskList listOfTasks;
    private Ui ui;

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

    public static void main(String[] args) {
        new Cookie("data/cookie.txt").run();
    }
}
