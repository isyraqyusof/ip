import java.util.Scanner;
public class Cookie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            else {
                System.out.println(line);
                System.out.println(input);
                System.out.println(line);
            }
        }
    }
}
