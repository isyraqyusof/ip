import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter FORMAT_FOR_INPUT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter FORMAT_FOR_OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy HHmm");


    public Event(String description, String from, String to) throws CookieException {
        super(description);
        try {
            this.from = LocalDateTime.parse(from.strip(), FORMAT_FOR_INPUT);
            this.to = LocalDateTime.parse(to.strip(), FORMAT_FOR_INPUT);

        } catch (DateTimeParseException e) {
            throw new CookieException("Please specify date in the following format: yyyy-MM-dd HHmm");
        }
    }

    @Override
    public String toStoredFormat() {
        int status = isDone ? 1 : 0;
        return "E | " + status + " | " + description + " | " + from.format(FORMAT_FOR_INPUT)
                + " | " + to.format(FORMAT_FOR_INPUT);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(FORMAT_FOR_OUTPUT)
                + " to: " + to.format(FORMAT_FOR_OUTPUT) + ")";
    }
}

