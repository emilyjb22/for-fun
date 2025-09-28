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

        // obtain "Adam" (aka starter male person)
        ArrayList<Male> allMales = new ArrayList<Male>();

        System.out.println("To get started, we need at least one male person and one female person.");
        input.nextLine();
        System.out.println("Let's start with Adam.");
        input.nextLine();

        System.out.println("""
        This is Adam Paper. He needs DNA.
        Do you want to choose his hair and eye color manually, or do you want to randomize it?"
        --------------------------------------------------------
        Please enter "1" or "2" to proceed
            1. Choose Hair and Eye Color manually
            2. Randomize Hair and Eye Color
        --------------------------------------------------------
        """);
        choice = input.nextLine();

        Eyes eyeChoice = new Eyes();
        Hair hairChoice = new Hair();
            if (choice.equals("1")){
                eyeChoice.selectEyeColor(input, eyeChoice.eyeColorMap);
                hairChoice.selectHairColor(input);
                hairChoice.generateHairColorGenotype();
            }
            else if (choice.equals("2")){
                eyeChoice.randomizeEyeColor();
                hairChoice.randomizeHairGenotype();
                hairChoice.randomizeHairColor();

            }
            eyeChoice.getEyeColorGenotype();

        Male male = new Male("Adam","Paper","XY",eyeChoice,hairChoice);
        allMales.add(male);
        System.out.println(""
                            "Great! " + male.firstName + " " + male.lastName + " has been added to the population." +
                            "He has " + eyeChoice.eyeColor + " eyes and a genotype of " + eyeChoice.eyeColorGenotype + "." +
                            "He has " + hairChoice.hairColor + " hair and a genotype of " + hairChoice.hairColorGenotype + "."
                            "");
        input.nextLine();

        /*
        // obtain "Eve" (aka female starter person)
        ArrayList<Female> allFemales = new ArrayList<Female>();
        System.out.println("Next, let's make Eve.");
        input.nextLine();
        System.out.println("""
        This is Eve Paper. She also needs DNA.
        Do you want to choose her hair and eye color manually, or do you want to randomize it?"
        --------------------------------------------------------
        Please enter "1" or "2" to proceed
            1. Choose Hair and Eye Color manually
            2. Randomize Hair and Eye Color
        --------------------------------------------------------
        """);
        choice = input.nextLine();
        Female female = new Female();
            if (choice.equals("1")){
                female.getEyeColor(input, female.eyeColorMap);
                female.getHairColor(input);
            }
            else if (choice.equals("2")){
                female.eyeColor = Person.randomize(female.eyeColors, female.eyeColor);
                female.eyeColorGenotype = Person.getKeyByValue(female.eyeColorMap, female.eyeColor);
            }
        allFemales.add(female);
        System.out.println("Great! " + female.firstName + " " + female.lastName + " has been added to the population.");
        input.nextLine();*/

        System.out.println("Press enter to continue...");
    /*
        // get user input, until user exits program
        while (!choice.equals("4")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code*/
            switch (choice) {
                case "1" -> {}/*{
                    Male newMale = new Male();

                    System.out.println("Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize. Type \"B\" to go back to main menu.");
                    String selection = input.nextLine();

                    if (selection.equalsIgnoreCase("R")) {
                        selection = Person.randomize(Person.sexes, Person.sex);
                    }

                    selection = selection.toUpperCase();

                    switch (selection) {
                        case "XY", "XX" -> {
                            if (selection.equalsIgnoreCase("XY")) {
                                System.out.println("Your person's name is " + newMale.getMaleName(input) + " " + newMale.getLastName(input) +".");
                                newMale.getEyeColor(input, newMale.eyeColorMap);
                                newMale.getHairColor(input);
                            }
                            else {
                                female = new Female();
                                System.out.println("Your person's name is " + female.getFemaleName(input) + " " + female.getLastName(input) +".");
                                female.getEyeColor(input,female.eyeColorMap);
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
                        if (selection.equalsIgnoreCase("XY") && newMale != null) {
                            allMales.add(newMale);
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
                }*/

                case "2" -> {
                   System.out.println("Are you ready to have a baby? Select a dad from the following list:");
                   for (Object m : allMales) { System.out.println(m.toString());
                    } 
                }
                case "3" -> {
                    //need to make this print better
                    System.out.println("Here is your current population:");
                    for (Object m : allMales) { System.out.println(male.toString());
                    } 
                    //for (Object f : allFemales) { System.out.println(female.toString());
                    }
                    
                

                case "4" -> {
                    
                }
                case "5" -> {
                }
                
                default -> {System.out.println("Invalid entry. Please enter a number between 1 and 4.");}
            }
        }
    }

class Dashboard {

    String title ="""
                --------------------------------------------------------
                        Paper People Project
                --------------------------------------------------------
                    A simulation using simple Mendelian inheritance              
                --------------------------------------------------------
                """;

    String menu = """
                -------------------------------------------------------
                Menu:
                   1.  Create a New Person
                   2.  Have a Baby
                   3.  View Your Population
                   4.  Exit
                   5.  Test a New Method
                ------------------------------------------------------
                """;
}
