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
    public static void hairAndEyes(String choice, Scanner input, Eyes eyes, Hair hair, Male dad, Female mom) {
        // option 1 select manually
        if (choice.equals("1")) {
            eyes.setEyeColor(eyes.selectPhenotype(Eyes.getSelectionMenu(), input, Eyes.getEyeColors()));
            eyes.setEyeColorGenotype(eyes.generateGenotype(Eyes.getEyeColorMap(), eyes.getEyeColor()));
            hair.setHairColor(hair.selectPhenotype(Hair.getSelectionMenu(), input, Hair.getHairColors()));
            hair.setHairColorGenotype(hair.generateGenotype(Hair.getHairColorMap(), hair.getHairColor()));

            // option 2 randomize
        } else if (choice.equals("2")) {
            int geno = Eyes.randomGenotype(dad.eyes.getEyeColorGenotype(), mom.eyes.getEyeColorGenotype());
            eyes.setEyeColorGenotype(geno);
            eyes.setEyeColor(Eyes.phenotypeFromGenotype(Eyes.getEyeColorMap(), geno));

            geno = Hair.randomGenotype(dad.hair.getHairColorGenotype(), mom.hair.getHairColorGenotype());
            hair.setHairColorGenotype(geno);
            hair.setHairColor(Hair.phenotypeFromGenotype(Hair.getHairColorMap(), geno));
        }

    }

    // make Adam
    public static Male createAdam(String choice, Scanner input, Eyes eyes, Hair hair) {
        Male adamDad = new Male();
        Female adamMom = new Female();
        Dashboard.hairAndEyes(choice, input, eyes, hair, adamDad, adamMom);
        Male adam = new Male("Adam", "Paper", "XY", eyes, hair, adamDad, adamMom);
        System.out.println(adam.toString());
        return adam;
    }

    // make Eve
    public static Female createEve(String choice, Scanner input, Eyes eyes, Hair hair) {
        Male eveDad = new Male();
        Female eveMom = new Female();
        Dashboard.hairAndEyes(choice, input, eyes, hair, eveDad, eveMom);
        Female eve = new Female("Eve", "Paper", "XX", eyes, hair, eveDad, eveMom);
        System.out.println(eve.toString());
        return eve;
    }

}
