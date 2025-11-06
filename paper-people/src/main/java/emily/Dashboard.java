package emily;

import java.util.Scanner;
import emily.people.Female;
import emily.people.Male;
import emily.traits.Eyes;
import emily.traits.Hair;

public class Dashboard {

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

    public static String traitSelectMenu = """
            Do you want to choose their hair and eye color manually, or do you want to randomize them?"
            --------------------------------------------------------
            Please enter "1" or "2" to proceed
                1. Choose Hair and Eye Color manually
                2. Randomize Hair and Eye Color
            --------------------------------------------------------
            """;

    // This is Adam Paper. He needs DNA.

    // generic method to handle hair and eyes
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

}
