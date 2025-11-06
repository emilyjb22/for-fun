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
        System.out.println(Dashboard.traitSelectMenu);

        String choice = input.nextLine();
        Male dad = new Male();
        Female mom = new Female();
        Eyes eyes = new Eyes();
        Hair hair = new Hair();

        Dashboard.hairAndEyes(choice, input, eyes, hair, dad, mom);

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(firstName);
        person.setLastName("Paper");

        setAndPrintPerson(person, eyes, hair);
        return person;
    }

    public static Person createStarterPerson(
            String message,
            Scanner input,
            boolean isMale) {

        System.out.println(message);
        System.out.println(Dashboard.traitSelectMenu);

        String choice = input.nextLine();
        Male dad = new Male();
        Female mom = new Female();
        Eyes eyes = new Eyes();
        Hair hair = new Hair();

        Dashboard.hairAndEyes(choice, input, eyes, hair, dad, mom);

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(isMale ? dad.getMaleName(input) : mom.getFemaleName(input));
        person.setLastName(person.makeLastName(input));

        setAndPrintPerson(person, eyes, hair);
        return person;
    }

    public static Male createAdam(String messageA, String messageB, Scanner input) {
        return (Male) createStarterPerson(messageA, messageB, input, "Adam", true);
    }

    public static Female createEve(String messageA, String messageB, Scanner input) {
        return (Female) createStarterPerson(messageA, messageB, input, "Eve", false);
    }

    public static Male createMan(String message, Scanner input) {
        return (Male) createStarterPerson(message, input, true);
    }

    public static Female createWoman(String message, Scanner input) {
        return (Female) createStarterPerson(message, input, false);
    }

    private static void setAndPrintPerson(Person person, Eyes eyes, Hair hair) {
        person.setEyes(eyes);
        person.setHair(hair);
        System.out.println("Great! " + person.getFirstName() + " has " +
                eyes.getEyeColor() + " eyes (" + eyes.getEyeColorGenotype() + ")" +
                " and " + hair.getHairColor() + " hair (" + hair.getHairColorGenotype() + ").");
    }
}
