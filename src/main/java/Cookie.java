import java.util.Scanner;
public class Cookie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] storage = new String[100];
        int counter = 0;

        String line = "___________________________________";
        System.out.println(line);
        System.out.println("Hello! I'm Cookie");
        System.out.println("What can I do for you?");
        System.out.println(line);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(line);
                break;
            }
            else if (input.equals("list")) {
                int currentCount = 1;
                System.out.println(line);
                for (int i = 0; i < counter; i++) {
                    System.out.println(currentCount + ". " + storage[i]);
                    currentCount++;
                }
                System.out.println(line);
            }
            else {
                System.out.println(line);
                System.out.println("added: " + input);
                System.out.println(line);
                storage[counter] = input;
                counter++;
            }
        }
    }
}
