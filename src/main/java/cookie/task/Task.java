package cookie.task;

import cookie.exception.CookieException;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description.strip();
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    public abstract String toStoredFormat();

    public static Task toOriginalFormat(String storedFormat) throws CookieException {
        String[] splitStoredFormat = storedFormat.split("\\|");
        String typeOfTask = splitStoredFormat[0].strip();
        boolean isDone = splitStoredFormat[1].strip().equals("1");
        String description = splitStoredFormat[2].strip();

        switch (typeOfTask) {
            case "T":
                Task todo = new Todo(description);
                if (isDone) {
                    todo.markAsDone();
                }
                return todo;

            case "D":
                String by = splitStoredFormat[3].strip();
                Task deadline = new Deadline(description, by);
                if (isDone) {
                    deadline.markAsDone();
                }
                return deadline;

            case "E":
                String from = splitStoredFormat[3].strip();
                String to = splitStoredFormat[4].strip();
                Task event = new Event(description, from, to);
                if (isDone) {
                    event.markAsDone();
                }
                return event;

            default:
                throw new IllegalArgumentException("Task not in proper format");
        }
    }

    @Override
    public String toString() {
        return ("[" + getStatusIcon() + "] " + this.description);
    }
}
