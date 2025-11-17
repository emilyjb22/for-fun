package emily.people;

import emily.traits.Eyes;
import emily.traits.Hair;

public class Female extends Person {

    private String[] femaleNames = { "Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan",
            "Jessica",
            "Sarah", "Karen",
            "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily" };

    public Female() {
        firstName = "JANE";
        lastName = "DOE";
        isMale = false;
        eyes = super.eyes;
        hair = super.hair;
    }

    public Female(String firstName, String lastName, String sex, Eyes eyes, Hair hair, Male dad, Female mom) {
        this.firstName = firstName;
        this.lastName = lastName;
        isMale = false;
        this.eyes = eyes;
        this.hair = hair;
        this.dad = dad;
        this.mom = mom;
    }

    public String[] getFemaleNames() {
        return femaleNames;
    }
}
