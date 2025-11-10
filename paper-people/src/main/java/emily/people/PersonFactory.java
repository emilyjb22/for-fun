package emily.people;

import java.util.Scanner;
import emily.traits.Eyes;
import emily.traits.Hair;
import emily.Dashboard;

public class PersonFactory {

    public static Person createStarterPerson(
            String messageA,
            String messageB,
            Scanner input,
            String firstName,
            boolean isMale) {
        System.out.println(messageA);
        input.nextLine();
        System.out.println(messageB);

        Male dad = new Male();
        Female mom = new Female();

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(firstName);
        person.setLastName("Paper");

        Eyes eyes = new Eyes();
        Hair hair = new Hair();
        Dashboard.hairAndEyes(input, eyes, hair, dad, mom);

        setAndPrintPerson(person, eyes, hair);
        return person;
    }

    public static Person createBaby(
            Scanner input,
            Male dad,
            Female mom,
            boolean isMale) {

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(isMale
                ? person.makeFirstName(input, dad.getMaleNames(),
                        "Give him a first name, or enter \"R\" to randomize: ", "his")
                : person.makeFirstName(input, mom.getFemaleNames(),
                        "Give her a first name, or enter \"R\" to randomize: ", "her"));
        person.setLastName(dad.getLastName());

        Eyes eyes = new Eyes();
        Hair hair = new Hair();

        setAndPrintPerson(person, eyes, hair);
        return person;
    }

    // for creating a person "from scratch"
    public static Person createStarterPerson(
            Scanner input,
            Male dad,
            Female mom,
            boolean isMale) {

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(isMale
                ? person.makeFirstName(input, dad.getMaleNames(),
                        "Your person is a man. Give him a first name, or enter \"R\" to randomize: ", "his")
                : person.makeFirstName(input, mom.getFemaleNames(),
                        "Your person is a woman. Give her a first name, or enter \"R\" to randomize: ", "her"));
        person.setLastName(person.makeLastName(input));

        Eyes eyes = new Eyes();
        Hair hair = new Hair();
        Dashboard.hairAndEyes(input, eyes, hair, dad, mom);

        setAndPrintPerson(person, eyes, hair);
        return person;
    }

    public static Male createAdam(String messageA, String messageB, Scanner input) {
        return (Male) createStarterPerson(messageA, messageB, input, "Adam", true);
    }

    public static Female createEve(String messageA, String messageB, Scanner input) {
        return (Female) createStarterPerson(messageA, messageB, input, "Eve", false);
    }

    public static Male createMan(Scanner input, Male dad, Female mom) {
        return (Male) createStarterPerson(input, dad, mom, true);
    }

    public static Female createWoman(Scanner input, Male dad, Female mom) {
        return (Female) createStarterPerson(input, dad, mom, false);
    }

    private static void setAndPrintPerson(Person person, Eyes eyes, Hair hair) {
        person.setEyes(eyes);
        person.setHair(hair);
        System.out.println("Great! " + person.getFirstName() + " has " +
                eyes.getEyeColor() + " eyes (" + eyes.getEyeColorGenotype() + ")" +
                " and " + hair.getHairColor() + " hair (" + hair.getHairColorGenotype() + ").");
    }
}
