package cookie.task;

import cookie.exception.CookieException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    protected LocalDateTime by;
    private static final DateTimeFormatter FORMAT_FOR_INPUT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter FORMAT_FOR_OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy HHmm");


    public Deadline(String description, String by) throws CookieException {
        super(description);
        try {
            this.by = LocalDateTime.parse(by.strip(), FORMAT_FOR_INPUT);
        } catch (DateTimeParseException e) {
            throw new CookieException("Please specify date in the following format: yyyy-MM-dd HHmm");
        }
    }

    @Override
    public String toStoredFormat() {
        int status = isDone ? 1 : 0;
        return "D | " + status + " | " + description + " | " + by.format(FORMAT_FOR_INPUT);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(FORMAT_FOR_OUTPUT) + ")";
    }
}

