package emily;

import java.util.ArrayList;
import java.util.Scanner;

import emily.people.Female;
import emily.people.Male;
import emily.people.Person;
import emily.traits.Baby;
import emily.traits.Eyes;
import emily.traits.Hair;

/*import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import emily.fx.MainView;

/**
 * Hello world!
 */
public class App {//extends Application {

    /*@Override
    public void start(Stage mainStage) {
    mainStage.setTitle("This is GeneApp");
    Label label = new Label("Hello JavaFX!");
    Scene scene = new Scene(label, 400, 200);
    mainStage.setScene(scene);
    mainStage.show();
    }*/



    public static void main(String[] args) {

        //launch();
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
        choice = input.nextLine();
        Eyes eveEyes = new Eyes();
        Hair eveHair = new Hair();
        Female eve = Dashboard.createEve(choice, input, eveEyes, eveHair);
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
                        case "XY":
                            System.out.println("Your person's name is " + newMale.getMaleName(input) + " " + newMale.getLastName(input) +".");
                            break;
                        case "XX":
                            System.out.println("Your person's name is " + newFemale.getFemaleName(input) + " " + newFemale.getLastName(input) +".");
                            break;
                        default:
                            System.out.println("Invalid entry. Please try again.");
                            break;
                    }

                    System.out.println("""
                        Do you want to randomize their traits, or select their traits manually?
                        
                        Type \"1\" to select manually or \"2\" to randomize
                                """);
                    choice = input.nextLine();
                    Eyes newEyes = new Eyes();
                    Hair newHair = new Hair();

                    Dashboard.hairAndEyes(choice, input, newEyes, newHair);

                    if (selection.equals("XY")) {
                        Person.setAndPrintPerson(newMale, newEyes, newHair);
                    }
                    else if (selection.equals("XX")) {
                        Person.setAndPrintPerson(newFemale, newEyes, newHair);
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

                    //baby name not passing correctly
                    String sexOfBaby = Person.randomize(Person.sexes, Person.sex);
                    if (sexOfBaby.equals("XY")) {
                        baby.createBaby(dad, mom, input, babyEyes, babyHair, "Boy","boy", "his ");
                        Male babyBoy = new Male(baby.babyName, dad.lastName, sexOfBaby, babyEyes, babyHair, dad, mom);
                        allMales.add(babyBoy);
                        System.out.println(babyBoy.toString());
                    }
                    else {
                        baby.createBaby(dad, mom, input, babyEyes, babyHair, "Girl","girl", "her ");
                        Female babyGirl = new Female(baby.babyName, dad.lastName, sexOfBaby, babyEyes, babyHair, dad, mom);
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

// make Eve
    public static Female createEve(String choice, Scanner input, Eyes eyes, Hair hair){
        Dashboard.hairAndEyes(choice, input, eyes, hair);
        Female eve = new Female("Eve","Paper","XX",eyes,hair,new Male(),new Female());
        System.out.println(eve.toString());
        return eve;
}

}

