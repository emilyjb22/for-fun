package emily;

import java.util.ArrayList;
import java.util.Scanner;
import emily.people.Female;
import emily.people.Male;
import emily.people.Person;
import emily.people.PersonFactory;
import emily.traits.Trait;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();
        ArrayList<Male> allMales = new ArrayList<Male>();
        ArrayList<Female> allFemales = new ArrayList<Female>();

        // print title menu
        System.out.println(dashboard.title);
        Scanner input = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        input.nextLine();
        String choice = "";

        // obtain "Adam" and "Eve" (to start population)
        System.out.println("To get started, we need at least one male person and one female person.");
        input.nextLine();

        Male adam = PersonFactory.createAdam(
                "First, let's start with Adam.",
                "This is Adam Paper. He needs DNA.",
                input);
        allMales.add(adam);

        Female eve = PersonFactory.createEve(
                "Next, let's create Eve.",
                "This is Eve Paper. She also needs DNA.",
                input);
        allFemales.add(eve);

        System.out.println("Press enter to continue...");
        input.nextLine();

        // main menu loop
        while (!choice.equals("4")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            // switch between menu options to select relevant code*/
            switch (choice) {
                case "1" -> {

                    System.out.println(
                            "Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize. Type \"B\" to go back to main menu.");
                    String selection = input.nextLine();

                    boolean isMale;
                    String firstName;
                    Male dad = new Male();
                    Female mom = new Female();

                    if (selection.equalsIgnoreCase("XY")) {
                        isMale = true;
                    } else if (selection.equalsIgnoreCase("XX")) {
                        isMale = false;
                    } else if (selection.equalsIgnoreCase("R")) {
                        isMale = Math.random() < 0.5;
                    } else if (selection.equalsIgnoreCase("B")) {
                        break;
                    } else {
                        System.out.println("Invalid entry. Please try again.");
                        break;
                    }

                    if (isMale) {
                        System.out.println("Great! Let's create a man.");
                        firstName = PersonFactory.createMan(input, dad, mom).toString();
                        System.out.println(firstName);
                    } else {
                        System.out.println("Great! Let's create a woman.");
                        firstName = PersonFactory.createWoman(input, dad, mom).getFirstName();
                    }

                    System.out.println("Your person's name is " + firstName);

                    if (selection.equals("XY")) {
                        // Person.setAndPrintPerson(newMale, newEyes, newHair);
                    } else if (selection.equals("XX")) {
                        // Person.setAndPrintPerson(newFemale, newEyes, newHair);
                    }

                    System.out.println();
                    System.out.println("Do you want to save this person to your population? (Y/N)");
                    String save = input.nextLine();

                    if (save.equalsIgnoreCase("Y")) {
                        // if (selection.equalsIgnoreCase("XY") && newMale != null) {
                        // allMales.add(newMale);
                        System.out.println("Person saved to your population.");
                        // } else if (selection.equalsIgnoreCase("XX") && newFemale != null) {
                        // allFemales.add(newFemale);
                        System.out.println("Person saved to your population.");
                    } else {
                        System.out.println("Person not saved.");
                    }
                    // } else {
                    System.out.println("Person not saved.");
                }

                case "2" -> {
                    System.out.println("Are you ready to have a baby?");

                    Male dad = (Male) Trait.selectParent("dad", allMales, input);
                    Female mom = (Female) Trait.selectParent("mom", allFemales, input);

                    System.out.println("Gestating baby...");
                    input.nextLine();

                    boolean isMale = Math.random() < 0.5;
                    Person baby = PersonFactory.createStarterPerson(input, dad, mom, isMale);

                    /*
                     * Baby baby = new Baby();
                     * Eyes babyEyes = new Eyes();
                     * Hair babyHair = new Hair();
                     * // babyHair.getHairColorMap();
                     * int babyEyeColorGenotype =
                     * baby.getBabyEyeColorGenotype(dad.eyes.getEyeColorGenotype(),
                     * mom.eyes.getEyeColorGenotype());
                     * String babyEyeColor =
                     * babyEyes.getEyeColorMap().get(String.valueOf(babyEyeColorGenotype));
                     * int babyHairColorGenotype =
                     * baby.getBabyHairColorGenotype(dad.hair.getHairColorGenotype(),
                     * mom.hair.getHairColorGenotype());
                     * String babyHairColor =
                     * babyHair.HAIR_COLOR_MAP.get(String.valueOf(babyHairColorGenotype));
                     * 
                     * babyEyes.setEyeColorGenotype(babyEyeColorGenotype);
                     * babyEyes.setEyeColor(babyEyeColor);
                     * babyHair.setHairColorGenotype(babyHairColorGenotype);
                     * babyHair.setHairColor(babyHairColor);
                     * // baby name not passing correctly
                     * String sexOfBaby = Person.randomize(Person.sexes, Person.sex);
                     * if (sexOfBaby.equals("XY")) {
                     * baby.createBaby(dad, mom, input, babyEyes, babyHair, "Boy", "boy", "his ");
                     * Male babyBoy = new Male(baby.babyName, dad.lastName, sexOfBaby, babyEyes,
                     * babyHair, dad, mom);
                     * allMales.add(babyBoy);
                     * System.out.println(babyBoy.toString());
                     * } else {
                     * baby.createBaby(dad, mom, input, babyEyes, babyHair, "Girl", "girl", "her ");
                     * Female babyGirl = new Female(baby.babyName, dad.lastName, sexOfBaby,
                     * babyEyes, babyHair, dad,
                     * mom);
                     * allFemales.add(babyGirl);
                     * System.out.println(babyGirl.toString());
                     * }
                     */
                }
                case "3" -> {
                    // need to make this print better
                    System.out.println("Here is your current population:");
                    for (Male m : allMales) {
                        System.out.println(m.toString());
                    }
                    for (Female f : allFemales) {
                        System.out.println(f.toString());
                    }
                }
                case "4" -> {
                }
                case "5" -> {
                }

                default -> {
                    System.out.println("Invalid entry. Please enter a number between 1 and 4.");
                }
            }
        }
    }
}
