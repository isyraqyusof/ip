package cookie.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toStoredFormat() {
        int status = isDone ? 1 : 0;
        return "T | " + status + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

