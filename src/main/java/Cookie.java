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
            String[] splitInput = fullInput.split(" ");
            if (fullInput.equals("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(line);
                break;
            }
            else if (fullInput.equals("list")) {
                int currentCount = 1;
                System.out.println(line);
                System.out.println("Here are your tasks:");
                for (int i = 0; i < counter; i++) {
                    System.out.println(currentCount + ". " + listOfTasks[i]);
                    currentCount++;
                }
                System.out.println(line);
            }
            else if (splitInput[0].equals("mark")) {
                int indexToBeMarked = Integer.parseInt(splitInput[1]) - 1;
                listOfTasks[indexToBeMarked].markAsDone();
                System.out.println(line);
                System.out.println("Great! I've marked this task as done:");
                System.out.println(listOfTasks[indexToBeMarked]);
                System.out.println(line);
            }
            else if (splitInput[0].equals("unmark")) {
                int indexToBeUnmarked = Integer.parseInt(splitInput[1]) - 1;
                listOfTasks[indexToBeUnmarked].markAsUndone();
                System.out.println(line);
                System.out.println("Alright. I've marked this task as not done yet:");
                System.out.println(listOfTasks[indexToBeUnmarked]);
                System.out.println(line);
            }
            else {
                System.out.println(line);
                System.out.println("added: " + fullInput);
                System.out.println(line);
                Task newTask = new Task(fullInput);
                listOfTasks[counter] = newTask;
                counter++;
            }
        }
    }
}
