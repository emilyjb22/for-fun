package emily;

import java.util.Scanner;
import emily.people.Female;
import emily.people.Male;
import emily.traits.Eyes;
import emily.traits.Hair;

class Dashboard {

    String title = """
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
    public static void hairAndEyes(String choice, Scanner input, Eyes eyes, Hair hair) {
        // option 1 select manually
        if (choice.equals("1")) {
            eyes.setEyeColor(eyes.selectPhenotype(Eyes.getSelectionMenu(), input, Eyes.getEyeColors()));
            hair.setHairColor(hair.selectPhenotype(Hair.getSelectionMenu(), input, Hair.getHairColors()));
            hair.setHairColorGenotype(hair.generateGenotype(Hair.getHairColorMap(), hair.getHairColor()));

            // option 2 randomize
        } else if (choice.equals("2")) {
            // eyes.eyes.setEyeColor(eyes.randomizePhenotype(Eyes.getEyeColors()));
            // hair.randomizeHair();
            // hair.setHairColorGenotype(hair.makeHairColorGenotype());
            // hair.setHairColor(hair.randomizeHairColor());
            // resume work here ^

        }
        eyes.setEyeColorGenotype(eyes.generateGenotype(Eyes.getEyeColorMap(), eyes.getEyeColor()));
    }

    // make Adam
    public static Male createAdam(String choice, Scanner input, Eyes eyes, Hair hair) {
        Dashboard.hairAndEyes(choice, input, eyes, hair);
        Male adam = new Male("Adam", "Paper", "XY", eyes, hair, new Male(), new Female());
        System.out.println(adam.toString());
        return adam;
    }

    // make Eve
    public static Female createEve(String choice, Scanner input, Eyes eyes, Hair hair) {
        Dashboard.hairAndEyes(choice, input, eyes, hair);
        Female eve = new Female("Eve", "Paper", "XX", eyes, hair, new Male(), new Female());
        System.out.println(eve.toString());
        return eve;
    }

}
