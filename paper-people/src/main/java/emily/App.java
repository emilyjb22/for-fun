package emily;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();
        ArrayList<Male> allMales = new ArrayList<Male>();
        ArrayList<Female> allFemales = new ArrayList<Female>();

        //print title menu
        System.out.println(dashboard.title);
        Scanner input = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        input.nextLine();
        String choice = "";

        // obtain "Adam" (aka starter male person)
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
        Eyes adamEyes = new Eyes();
        Hair adamHair = new Hair();
        Male adam = Dashboard.createAdam(choice, input, adamEyes, adamHair);
        allMales.add(adam);
        System.out.println("Great! " + adam.firstName + " " + adam.lastName + " has been added to the population.\n"
                            + "He has " + adamEyes.getEyeColor() + " eyes and a genotype of " + adamEyes.getEyeColorGenotype() + ".\n"
                            + "He has " + adamHair.getHairColor() + " hair and a genotype of " + adamHair.getHairColorGenotype() + ".");
        input.nextLine();

        
        // obtain "Eve" (aka female starter person)
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
        Eyes eveEyes = new Eyes();
        Hair eveHair = new Hair();
        eveHair.getHairColorMap();
        choice = input.nextLine();
            if (choice.equals("1")){
                eveEyes.setEyeColor(eveEyes.selectEyeColor(input));
                eveHair.setHairColor(eveHair.selectHairColor(input));
                eveHair.setHairColorGenotype(eveHair.generateHairColorGenotype());
            }
            else if (choice.equals("2")){
                eveEyes.setEyeColor(eveEyes.randomizeEyeColor());
                eveHair.randomizeHair();
                eveHair.setHairColorGenotype(eveHair.makeHairColorGenotype());
                eveHair.setHairColor(eveHair.randomizeHairColor());

            }
            eveEyes.setEyeColorGenotype(eveEyes.generateEyeColorGenotype());

        Female eve = new Female("Eve","Paper","XX",eveEyes,eveHair,new Male(),new Female());
        allFemales.add(eve);
        System.out.println("Great! " + eve.firstName + " " + eve.lastName + " has been added to the population.\n"
                            + "She has " + eveEyes.getEyeColor() + " eyes and a genotype of " + eveEyes.getEyeColorGenotype() + ".\n"
                            + "She has " + eveHair.getHairColor() + " hair and a genotype of " + eveHair.getHairColorGenotype() + ".");
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
                    newHair.getHairColorMap();
                    
                    if (choice.equalsIgnoreCase("R")) {
                        newEyes.randomizeEyeColor();
                        newHair.randomizeHair();
                        newHair.makeHairColorGenotype();
                        newHair.randomizeHairColor();
                    }
                    else {
                        newEyes.selectEyeColor(input);
                        newHair.selectHairColor(input);
                        newHair.generateHairColorGenotype();
                    }
                    newEyes.generateEyeColorGenotype();

                    if (selection.equals("XY")) {
                        newMale.setEyes(newEyes);
                        newMale.setHair(newHair);
                        System.out.println("Great! " + newMale.firstName + " has " + newEyes.getEyeColor() + " eyes and a genotype of " + newEyes.getEyeColorGenotype() + ".\n"
                            + "He has " + newHair.getHairColor() + " hair and a genotype of " + newHair.getHairColorGenotype() + ".");
                    }
                    else if (selection.equals("XX")) {
                        newFemale.setEyes(newEyes);
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
                   int count = allMales.size();
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + allMales.get(i).toString());
                        }
                    int dadIndex = input.nextInt() - 1;
                    Male dad = allMales.get(dadIndex);
                    System.out.println("Great! You selected " + dad.firstName + " " + dad.lastName + " as the dad.");
                    System.out.println("--------------------------------------------------------");
                    
                    input.nextLine();
                    System.out.println("Now select a mom from the following list:");
                    count = allFemales.size();
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + allFemales.get(i).toString());
                        }
                    int momIndex = input.nextInt() - 1;
                    Female mom = allFemales.get(momIndex);
                    System.out.println("Great! You selected " + mom.firstName + " " + mom.lastName + " as the mom.");
                    System.out.println("--------------------------------------------------------");
                        
                    input.nextLine();
                    System.out.println("Gestating baby...");
                    input.nextLine();

                    Baby baby = new Baby();
                    Eyes babyEyes = new Eyes();
                    Hair babyHair = new Hair();
                    babyHair.getHairColorMap();
                
                    int babyEyeColorGenotype = baby.getBabyEyeColorGenotype(dad.eyes.getEyeColorGenotype(),mom.eyes.getEyeColorGenotype() );
                    String babyEyeColor = babyEyes.getEyeColorMap().get(String.valueOf(babyEyeColorGenotype));
                    int babyHairColorGenotype = baby.getBabyHairColorGenotype(dad.hair.getHairColorGenotype(),mom.hair.getHairColorGenotype() );
                    String babyHairColor = babyHair.getHairColorMap().get(String.valueOf(babyHairColorGenotype));

                    babyEyes.setEyeColorGenotype(babyEyeColorGenotype);
                    babyEyes.setEyeColor(babyEyeColor);
                    babyHair.setHairColorGenotype(babyHairColorGenotype);
                    babyHair.setHairColor(babyHairColor);

                    String sexOfBaby = Person.randomize(Person.sexes, Person.sex);
                    if (sexOfBaby.equals("XY")) {
                        System.out.println("Congratulations! " + mom.firstName + " and " + dad.firstName + " had a baby boy!");
                        System.out.println("Please give him a first name, or enter \"R\" to randomize: ");
                        String babyName = input.nextLine();
                        if (babyName.equalsIgnoreCase("R")) {
                            babyName = Person.randomize(dad.maleNames, babyName);
                        }
                        System.out.println("His name is " + babyName + " " + dad.lastName + ".");
                        Male babyBoy = new Male(babyName, dad.lastName, sexOfBaby, babyEyes, babyHair, dad, mom);
                        allMales.add(babyBoy);
                        System.out.println(babyBoy.toString());
                    }
                    else {
                        System.out.println("Congratulations! " + mom.firstName + " and " + dad.firstName + " had a baby girl!");
                        System.out.println("Please give her a first name, or enter \"R\" to randomize: ");
                        String babyName = input.nextLine();
                        if (babyName.equalsIgnoreCase("R")) {
                            babyName = Person.randomize(mom.femaleNames, babyName);
                        }
                        System.out.println("Her name is " + babyName + " " + dad.lastName + ".");
                        Female babyGirl = new Female(babyName, dad.lastName, sexOfBaby, babyEyes, babyHair, dad, mom);
                        allFemales.add(babyGirl);
                        System.out.println(babyGirl.toString());
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

    // generic method to handle hair and eyes for Adam and Eve
    // maybe handle hair and eyes in other places too?
    public static void hairAndEyes(String choice, Scanner input, Eyes eyes, Hair hair){
        hair.getHairColorMap();
        if (choice.equals("1")){
                eyes.setEyeColor(eyes.selectEyeColor(input));
                hair.setHairColor(hair.selectHairColor(input));
                hair.setHairColorGenotype(hair.generateHairColorGenotype());
    }
        else if (choice.equals("2")){
                eyes.setEyeColor(eyes.randomizeEyeColor());
                hair.randomizeHair();
                hair.setHairColorGenotype(hair.makeHairColorGenotype());
                hair.setHairColor(hair.randomizeHairColor());
    }        
        eyes.setEyeColorGenotype(eyes.generateEyeColorGenotype());
}

// make Adam
    public static Male createAdam(String choice, Scanner input, Eyes eyes, Hair hair){
        Dashboard.hairAndEyes(choice, input, eyes, hair);
        Male adam = new Male("Adam","Paper","XY",eyes,hair,new Male(),new Female());
        System.out.println(adam.toString());
        return adam;
}

}

