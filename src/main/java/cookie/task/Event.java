package cookie.task;

import cookie.exception.CookieException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task with a specific start and end date and time.
 * Adds date and time functionality to base Task class.
 */
public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter FORMAT_FOR_INPUT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter FORMAT_FOR_OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy HHmm");

    /**
     * Creates new event task with the given description, start and end date and time.
     *
     * @param description Description of task.
     * @param from Start date and time for task.
     * @param to End date and time for task.
     * @throws CookieException If format of date and time is not yyyy-MM-dd HHmm.
     */
    public Event(String description, String from, String to) throws CookieException {
        super(description);
        try {
            this.from = LocalDateTime.parse(from.strip(), FORMAT_FOR_INPUT);
            this.to = LocalDateTime.parse(to.strip(), FORMAT_FOR_INPUT);

        } catch (DateTimeParseException e) {
            throw new CookieException("Please specify date in the following format: yyyy-MM-dd HHmm");
        }
    }

    /**
     * Converts event task into format for saving.
     *
     * @return Saved format of event task.
     */
    @Override
    public String toStoredFormat() {
        int status = isDone ? 1 : 0;
        return "E | " + status + " | " + description + " | " + from.format(FORMAT_FOR_INPUT)
                + " | " + to.format(FORMAT_FOR_INPUT);
    }

    /**
     * Returns event task in String format with its type, description,
     * from and to date and time.
     *
     * @return String form of event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(FORMAT_FOR_OUTPUT)
                + " to: " + to.format(FORMAT_FOR_OUTPUT) + ")";
    }
}

