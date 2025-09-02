package cookie.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import cookie.task.TaskList;
import cookie.task.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {
    @TempDir
    Path temp;

    @Test
    public void save_validInput_storesInExpectedFormat() throws IOException {
        TaskList listOfTasks = new TaskList();
        Todo todo = new Todo("sleep");
        listOfTasks.add(todo);

        Path testFile = temp.resolve("test.txt");
        Storage storage = new Storage(testFile.toString());

        storage.save(listOfTasks);

        assertEquals("T | 0 | sleep", Files.readString(testFile).strip());

    }

}