package emily.people;

import java.util.Scanner;

import emily.traits.Eyes;
import emily.traits.Hair;
import emily.RandomUtils;

public class Male extends Person {

    public String[] maleNames = { "James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph",
            "Thomas", "Charles",
            "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth" };

    public Male() {
        firstName = "JOHN";
        lastName = "DOE";
        sex = "XY";
        eyes = super.eyes;
        hair = super.hair;
    }

    public Male(String firstName, String lastName, String sex, Eyes eyes, Hair hair, Male dad, Female mom) {
        this.firstName = firstName;
        this.lastName = lastName;
        sex = "XY";
        this.eyes = eyes;
        this.hair = hair;
        this.dad = dad;
        this.mom = mom;
    }

    public String getMaleName(Scanner input) {
        System.out.println("Your person is a man. Give him a first name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            firstName = RandomUtils.random(maleNames);
        } else {
            firstName = name;
        }
        System.out.println("His first name is " + firstName + ".");
        return firstName;
    }

}
