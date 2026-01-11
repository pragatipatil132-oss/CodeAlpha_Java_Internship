import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        System.out.println("ChatBot: Hello! Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            } else if (userInput.contains("hello")) {
                System.out.println("ChatBot: Hello! How can I help you?");
            } else if (userInput.contains("java")) {
                System.out.println("ChatBot: Java is a powerful object-oriented programming language.");
            } else if (userInput.contains("internship")) {
                System.out.println("ChatBot: This internship helps improve Java and backend skills.");
            } else {
                System.out.println("ChatBot: Sorry, I don't understand.");
            }
        }
    }
}
