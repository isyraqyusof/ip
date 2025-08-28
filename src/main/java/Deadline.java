public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String toStoredFormat() {
        int status = isDone ? 1 : 0;
        return "D | " + status + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by + ")";
    }
}

