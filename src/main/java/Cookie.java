import java.util.Scanner;
public class Cookie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] listOfTasks = new Task[100];
        int counter = 0;

        String line = "___________________________________";
        System.out.println(line);
        System.out.println("Hey there! My name is Cookie");
        System.out.println("How can I help you?");
        System.out.println(line);

        while (true) {
            String fullInput = scanner.nextLine();
            String[] splitInput = fullInput.split(" ", 2);
            String firstWord = splitInput[0];

            try {
                if (fullInput.equals("bye")) {
                    System.out.println(line);
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println(line);
                    break;
                } else if (fullInput.equals("list")) {
                    int currentCount = 1;
                    System.out.println(line);
                    System.out.println("Here are your tasks:");
                    for (int i = 0; i < counter; i++) {
                        System.out.println(currentCount + ". " + listOfTasks[i]);
                        currentCount++;
                    }
                    System.out.println(line);
                } else if (firstWord.equals("mark")) {
                    if (fullInput.equals("mark")) {
                        throw new CookieException("Please specify which task you would like to mark.");
                    }
                    int indexToBeMarked = Integer.parseInt(splitInput[1]) - 1;
                    listOfTasks[indexToBeMarked].markAsDone();
                    System.out.println(line);
                    System.out.println("Great! I've marked this task as done:");
                    System.out.println(listOfTasks[indexToBeMarked]);
                    System.out.println(line);
                } else if (firstWord.equals("unmark")) {
                    if (fullInput.equals("unmark")) {
                        throw new CookieException("Please specify which task you would like to unmark.");
                    }
                    int indexToBeUnmarked = Integer.parseInt(splitInput[1]) - 1;
                    listOfTasks[indexToBeUnmarked].markAsUndone();
                    System.out.println(line);
                    System.out.println("Alright. I've marked this task as not done yet:");
                    System.out.println(listOfTasks[indexToBeUnmarked]);
                    System.out.println(line);
                } else if (firstWord.equals("todo")) {
                    if (fullInput.equals("todo")) {
                        throw new CookieException("Please provide a description for your todo task.");
                    }
                    Task newTodo = new Todo(splitInput[1]);
                    listOfTasks[counter] = newTodo;
                    counter++;
                    System.out.println(line);
                    System.out.println("A todo, got it! I've added this task:");
                    System.out.println(newTodo);
                    System.out.println("Now you have " + counter + " tasks in the list.");
                    System.out.println(line);
                } else if (firstWord.equals("deadline")) {
                    if (fullInput.equals("deadline") || !splitInput[1].contains("/by")) {
                        throw new CookieException("Please provide deadline in the format: {Description} /by {Day}");
                    }
                    String[] secondPhraseSplit = splitInput[1].split("/by");
                    String description = secondPhraseSplit[0];
                    String deadline = secondPhraseSplit[1];
                    Task newDeadline = new Deadline(description, deadline);
                    listOfTasks[counter] = newDeadline;
                    counter++;
                    System.out.println(line);
                    System.out.println("A deadline, got it! I've added this task:");
                    System.out.println(newDeadline);
                    System.out.println("Now you have " + counter + " tasks in the list.");
                    System.out.println(line);
                } else if (firstWord.equals("event")) {
                    if (fullInput.equals("event") || !splitInput[1].contains("/from") || !splitInput[1].contains("/to")) {
                        throw new CookieException("Please provide event in the format: {Description} /from {date/time} /to {date/time}");
                    }
                    String[] secondPhraseSplit = splitInput[1].split("/from");
                    String[] thirdPhraseSplit = secondPhraseSplit[1].split("/to");
                    String description = secondPhraseSplit[0];
                    String from = thirdPhraseSplit[0];
                    String to = thirdPhraseSplit[1];
                    Task newEvent = new Event(description, from, to);
                    listOfTasks[counter] = newEvent;
                    counter++;
                    System.out.println(line);
                    System.out.println("An event, got it! I've added this task:");
                    System.out.println(newEvent);
                    System.out.println("Now you have " + counter + " tasks in the list.");
                    System.out.println(line);
                } else {
                    throw new CookieException("Sorry! I'm not too sure what you mean!");
                }
            } catch (CookieException e) {
                System.out.println(line);
                System.out.println("Oh no! " + e.getMessage());
                System.out.println(line);
            }
        }
    }
}
