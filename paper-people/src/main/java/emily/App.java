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
        while (!choice.equals("4")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code
            switch (choice) {
                case "1" -> {
                    System.out.println("Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize. Type \"B\" to go back to main menu.");
                    String selection = input.nextLine();

                    if (selection.equalsIgnoreCase("R")) {
                        Person person = new Person();
                        selection = person.getRandomSex();
                    }

                    switch (selection) {
                        case "XY", "xy", "Xy", "xY" -> {
                            Male male = new Male();
                            System.out.println("Your person's name is " + male.getMaleName(input) + " " + male.getLastName(input) +".");
                        }
                        case "XX", "xx", "Xx", "xX" -> {
                            Female female = new Female();
                            System.out.println("Your person's name is " + female.getFemaleName(input) + " " + female.getLastName(input) +".");
                        }    
                        case "B", "b" -> {
                            break;
                        }
                        default -> System.out.println("Invalid entry. Please try again.");
                    }
                    System.out.println();
                    System.out.println("Do you want to save this person to your population? (Y/N)");
                    String save = input.nextLine();
                    
                    // for now, just print confirmation message; need to implement population storage
                    if (save.equalsIgnoreCase("Y")) {
                            System.out.println("Person saved to population.");
                    } else {
                            System.out.println("Person not saved.");
                    }
                }

                case "2" -> {

                  
                }
                case "3" -> {
                    
                }
                case "4" -> {
                    
                }
                default -> System.out.println("Invalid entry. Please enter a number between 1 and 4.");
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
                   1.  Create a New Person
                   2.  Have a Baby
                   3.  View Your Population
                   4.  Exit
                --------------------------------------
                """;

}