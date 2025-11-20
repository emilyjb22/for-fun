package emily.people;

import java.util.Scanner;
import emily.traits.Eyes;
import emily.traits.Hair;
import emily.traits.Trait;
import emily.utils.Ancillary;

public class PersonFactory {

    public static Person createStarterPerson(
            Scanner input,
            String firstName,
            String lastName,
            boolean isMale) {

        Ancillary.pause(input, "Creating person...");

        Male dad = new Male();
        Female mom = new Female();

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Eyes eyes = new Eyes();
        eyes = (Eyes) Trait.createTrait(isMale ? "his" : "her", "eye color", input, eyes, dad.getEyes().getGenotype(),
                mom.getEyes().getGenotype());
        System.out.println(firstName + " has " + eyes.getPhenotype() + " eyes (" + eyes.getGenotype() + ").");
        Hair hair = new Hair();
        hair = (Hair) Trait.createTrait(isMale ? "his" : "her", "hair color", input, hair, dad.getHair().getGenotype(),
                mom.getHair().getGenotype());
        System.out.println(firstName + " has " + hair.getPhenotype() + " hair (" + hair.getGenotype() + ").");
        person.setEyes(eyes);
        person.setHair(hair);

        return person;
    }

    public static Person createBaby(
            Scanner input,
            Male dad,
            Female mom,
            String name,
            boolean isMale) {

        Person person = isMale ? new Male() : new Female();
        person.setDad(dad);
        person.setMom(mom);
        person.setFirstName(name);
        person.setLastName(dad.getLastName());

        Eyes eyes = new Eyes();
        eyes = (Eyes) Trait.recombinate(eyes, dad.getEyes().getGenotype(), mom.getEyes().getGenotype());
        System.out.println(name + " has " + eyes.getPhenotype() + " eyes (" + eyes.getGenotype() + ").");
        Hair hair = new Hair();
        hair = (Hair) Trait.recombinate(hair, dad.getHair().getGenotype(), mom.getHair().getGenotype());
        System.out.println(name + " has " + eyes.getPhenotype() + " eyes (" + eyes.getGenotype() + ").");
        person.setEyes(eyes);
        person.setHair(hair);

        return person;
    }

    public static Male createMan(Scanner input) {
        return (Male) createStarterPerson(input, "Adam", "Paper", true);
    }

    public static Female createWoman(Scanner input) {
        return (Female) createStarterPerson(input, "Eve", "Paper", false);
    }
}
