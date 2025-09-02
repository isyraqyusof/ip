import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private final Path filePath;

    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public void save(TaskList listOfTasks) {
        ArrayList<String> listOfTasksInStoredFormat = new ArrayList<>();

        for (int i = 0; i < listOfTasks.size(); i++) {
            Task task = listOfTasks.get(i);
            listOfTasksInStoredFormat.add(task.toStoredFormat());
        }

        try {
            Files.write(filePath, listOfTasksInStoredFormat);
        } catch (IOException e) {
            System.out.println("Encountered an error when attempting to save the file.");
        }
    }

    public ArrayList<Task> load() throws CookieException {
        ArrayList<Task> listOfTasks = new ArrayList<>();

        if (!Files.exists(filePath)) {
            try {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
                return listOfTasks;
            } catch (IOException e) {
                System.out.println("Error in creating file.");
            }
        }

        try {
            List<String> listOfTasksInStoredFormat = Files.readAllLines(filePath);
            for (String taskInStoredFormat : listOfTasksInStoredFormat) {
                if (taskInStoredFormat == null || taskInStoredFormat.isBlank()) {
                    continue;
                }
                Task task = Task.toOriginalFormat(taskInStoredFormat);
                listOfTasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error in reading from file.");
        }
        return listOfTasks;
    }
}
