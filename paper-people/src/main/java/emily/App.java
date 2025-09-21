package emily;

import java.util.ArrayList;
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
        ArrayList<Male> allMales = new ArrayList<Male>();
        ArrayList<Female> allFemales = new ArrayList<Female>();

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
                        selection = Person.randomize(Person.sexes, Person.sex);
                    }

                    Male male = null;
                    Female female = null;

                    switch (selection) {
                        case "XY", "xy", "Xy", "xY", "XX", "xx", "Xx", "xX" -> {
                            if (selection.equalsIgnoreCase("XY")) {
                                male = new Male();
                                System.out.println("Your person's name is " + male.getMaleName(input) + " " + male.getLastName(input) +".");
                                male.getEyeColor(input);
                                male.getHairColor(input);
                            }
                            else {
                                female = new Female();
                                System.out.println("Your person's name is " + female.getFemaleName(input) + " " + female.getLastName(input) +".");
                                female.getEyeColor(input);
                                female.getHairColor(input);
                            }
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
                        if (selection.equalsIgnoreCase("XY") && male != null) {
                            allMales.add(male);
                            System.out.println("Person saved to your population.");
                        } else if (selection.equalsIgnoreCase("XX") && female != null) {
                            allFemales.add(female);
                            System.out.println("Person saved to your population.");
                        } else {
                            System.out.println("Person not saved.");
                        }
                    } else {
                        System.out.println("Person not saved.");
                    }
                }

                case "2" -> {

                  
                }
                case "3" -> {
                    //need to make this print better
                    System.out.println("Here is your current population:");
                    for (Object male : allMales) { System.out.println(male.toString());
                    } 
                    for (Object female : allFemales) { System.out.println(female.toString());
                    }
                    
                }
                case "4" -> {
                    
                }
                case "5" -> {
                    
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
                   5.  Test a New Method
                --------------------------------------
                """;

}