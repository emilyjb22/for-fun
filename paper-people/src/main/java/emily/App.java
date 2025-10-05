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
        hairChoice.makeHashMap();
            if (choice.equals("1")){
                eyeChoice.setEyeColor(eyeChoice.selectEyeColor(input));
                hairChoice.setHairColor(hairChoice.selectHairColor(input));
                hairChoice.setHairColorGenotype(hairChoice.generateHairColorGenotype());
            }
            else if (choice.equals("2")){
                eyeChoice.setEyeColor(eyeChoice.randomizeEyeColor());
                hairChoice.randomizeHair();
                hairChoice.setHairColorGenotype(hairChoice.makeHairColorGenotype());
                hairChoice.setHairColor(hairChoice.randomizeHairColor());

            }
            eyeChoice.setEyeColorGenotype(eyeChoice.generateEyeColorGenotype());

        Male adam = new Male("Adam","Paper","XY",eyeChoice,hairChoice);
        allMales.add(adam);
        System.out.println("Great! " + adam.firstName + " " + adam.lastName + " has been added to the population.\n"
                            + "He has " + eyeChoice.getEyeColor() + " eyes and a genotype of " + eyeChoice.getEyeColorGenotype() + ".\n"
                            + "He has " + hairChoice.getHairColor() + " hair and a genotype of " + hairChoice.getHairColorGenotype() + ".");
        input.nextLine();

        
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
            if (choice.equals("1")){
                eyeChoice.setEyeColor(eyeChoice.selectEyeColor(input));
                hairChoice.setHairColor(hairChoice.selectHairColor(input));
                hairChoice.setHairColorGenotype(hairChoice.generateHairColorGenotype());
            }
            else if (choice.equals("2")){
                eyeChoice.setEyeColor(eyeChoice.randomizeEyeColor());
                hairChoice.randomizeHair();
                hairChoice.setHairColorGenotype(hairChoice.makeHairColorGenotype());
                hairChoice.setHairColor(hairChoice.randomizeHairColor());

            }
            eyeChoice.setEyeColorGenotype(eyeChoice.generateEyeColorGenotype());

        Female eve = new Female("Eve","Paper","XX",eyeChoice,hairChoice);
        allFemales.add(eve);
        System.out.println("Great! " + eve.firstName + " " + eve.lastName + " has been added to the population.\n"
                            + "She has " + eyeChoice.getEyeColor() + " eyes and a genotype of " + eyeChoice.getEyeColorGenotype() + ".\n"
                            + "She has " + hairChoice.getHairColor() + " hair and a genotype of " + hairChoice.getHairColorGenotype() + ".");
        input.nextLine();

        System.out.println("Press enter to continue...");
   
        // get user input, until user exits program
        while (!choice.equals("4")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code*/
            switch (choice) {
                case "1" -> {
                    Male newMale = new Male();
                    Female newFemale = new Female();

                    System.out.println("Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize. Type \"B\" to go back to main menu.");
                    String selection = input.nextLine();

                    if (selection.equalsIgnoreCase("R")) {
                        selection = Person.randomize(Person.sexes, Person.sex);
                    }

                    selection = selection.toUpperCase();

                    switch (selection) {
                        case "XY" -> {
                                System.out.println("Your person's name is " + newMale.getMaleName(input) + " " + newMale.getLastName(input) +".");
                        }
                        case "XX" -> {
                                System.out.println("Your person's name is " + newFemale.getFemaleName(input) + " " + newFemale.getLastName(input) +".");
                            }
                        default -> System.out.println("Invalid entry. Please try again.");
                    }

                    System.out.println("""
                        Do you want to randomize their traits, or select their traits manually?
                        
                        Type \"R\" to randomize, or \"S\" to select manually
                                """);
                    choice = input.nextLine();
                    Eyes newEyes = new Eyes();
                    Hair newHair = new Hair();
                    newHair.makeHashMap();
                    
                    if (choice.equalsIgnoreCase("R")) {
                        newEyes.randomizeEyeColor();
                        newEyes.generateEyeColorGenotype();
                        newHair.randomizeHair();
                        newHair.makeHairColorGenotype();
                        newHair.randomizeHairColor();
                    }
                    else {
                        newEyes.selectEyeColor(input);
                        newHair.selectHairColor(input);
                        newHair.generateHairColorGenotype();
                    }

                    if (selection.equals("XY")) {
                        newMale.setEyes(newEyes);
                        newMale.setHair(newHair);
                        System.out.println("Great! " + newMale.firstName + " has " + newEyes.getEyeColor() + " eyes and a genotype of " + newEyes.getEyeColorGenotype() + ".\n"
                            + "He has " + newHair.getHairColor() + " hair and a genotype of " + newHair.getHairColorGenotype() + ".");
                    }
                    else if (selection.equals("XX")) {
                        //newFemale.setEyes(newEyes);
                        newFemale.setHair(newHair);
                        System.out.println("Great! " + newFemale.firstName + " has " + newEyes.getEyeColor() + " eyes and a genotype of " + newEyes.getEyeColorGenotype() + ".\n"
                            + "She has " + newHair.getHairColor() + " hair and a genotype of " + newHair.getHairColorGenotype() + ".");
                    }

                    System.out.println();
                    System.out.println("Do you want to save this person to your population? (Y/N)");
                    String save = input.nextLine();
                    
                    if (save.equalsIgnoreCase("Y")) {
                        if (selection.equalsIgnoreCase("XY") && newMale != null) {
                            allMales.add(newMale);
                            System.out.println("Person saved to your population.");
                        } else if (selection.equalsIgnoreCase("XX") && newFemale != null) {
                            allFemales.add(newFemale);
                            System.out.println("Person saved to your population.");
                        } else {
                            System.out.println("Person not saved.");
                        }
                    } else {
                        System.out.println("Person not saved.");
                    }
                }

                case "2" -> {
                   System.out.println("Are you ready to have a baby? Select a dad from the following list:");
                   for (Male m : allMales) { System.out.println(m.toString());
                    } 
                }
                case "3" -> {
                    //need to make this print better
                    System.out.println("Here is your current population:");
                    for (Male m : allMales) { System.out.println(m.toString());
                    } 
                    for (Female f : allFemales) { System.out.println(f.toString());
                    }
                }
                case "4" -> {    
                }
                case "5" -> {


                }
                
                default -> {System.out.println("Invalid entry. Please enter a number between 1 and 4.");}
            }
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
                --------------------------------------------------------
                Menu:
                   1.  Create a New Person
                   2.  Have a Baby
                   3.  View Your Population
                   4.  Exit
                   5.  Test a New Method
                --------------------------------------------------------
                """;
}

