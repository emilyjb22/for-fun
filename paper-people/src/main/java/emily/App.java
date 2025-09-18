package emily;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //print title menu
        System.out.println(new Dashboard().title);

        Scanner input = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        input.nextLine();

        String choice = "";

        // get user input, until user exits program
        while (!choice.equals("5")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code
            switch (choice) {
                case "1" -> {
                    Person p = new Person();
                    System.out.println(p);
                }
                case "2" -> {
                  
                }
                case "3" -> {
                    
                }
                case "4" -> {
                    
                }
               
                case "5" -> {

                }
                default -> System.out.println("Invalid entry. Please enter a number between 1 and 5.");
            }
        }
    }
}

class Dashboard {

    String title ="""
                --------------------------------------
                        Paper People Project
                --------------------------------------
                    A game of simple inheritance
                --------------------------------------
                """;

    String menu = """
                --------------------------------------
                Menu:
                   1.  Create a New Person (Random)
                   2.  Create a New Person (Custom)
                   3.  Have a Baby
                   4.  View Your Population
                   5.  Exit
                --------------------------------------
                """;

}