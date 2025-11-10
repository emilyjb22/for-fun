package emily;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import emily.people.Female;
import emily.people.Male;
import emily.people.Person;
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

    // generic method to handle hair and eyes
    public static void hairAndEyes(Scanner input, Eyes eyes, Hair hair, Male dad, Female mom) {
        System.out.println(traitSelectMenu);
        String choice = input.nextLine();
        // option 1 select manually
        if (choice.equals("1")) {
            eyes.setEyeColor(eyes.selectPhenotype(Eyes.getSelectionMenu(), input, Eyes.getEyeColors()));
            eyes.setEyeColorGenotype(eyes.generateGenotype(Eyes.getEyeColorMap(), eyes.getEyeColor()));
            hair.setHairColor(hair.selectPhenotype(Hair.getSelectionMenu(), input, Hair.getHairColors()));
            hair.setHairColorGenotype(hair.generateGenotype(Hair.getHairColorMap(), hair.getHairColor()));

            // option 2 randomize
        } else if (choice.equals("2")) {
            int geno = Eyes.randomGenotype(dad.getEyes().getEyeColorGenotype(), mom.getEyes().getEyeColorGenotype());
            eyes.setEyeColorGenotype(geno);
            eyes.setEyeColor(Eyes.phenotypeFromGenotype(Eyes.getEyeColorMap(), geno));

            geno = Hair.randomGenotype(dad.getHair().getHairColorGenotype(), mom.getHair().getHairColorGenotype());
            hair.setHairColorGenotype(geno);
            hair.setHairColor(Hair.phenotypeFromGenotype(Hair.getHairColorMap(), geno));
        }

    }

    // User selects phenotype from printed list
    public String selectPhenotype(String selectionMenu, Scanner input, List<String> phenoList) {
        System.out.println(selectionMenu);
        for (String pheno : phenoList) {
            System.out.println("- " + pheno);
        }
        phenotype = input.nextLine();
        return phenotype;
    }

    // Randomized phenotype from list (user selects "R")
    public String randomizePhenotype(List<String> phenoList) {
        phenotype = RandomUtils.random(phenoList);
        return phenotype;
    }

    // choose a parent from population list
    public static Person selectParent(String type, ArrayList<? extends Person> parentList, Scanner input) {
        System.out.println("Select a " + type + " from the following list:");
        int count = parentList.size();
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + parentList.get(i).toString());
        }
        int parentIndex = input.nextInt() - 1;
        Person parent = parentList.get(parentIndex);
        System.out.println(
                "Great! You selected " + parent.getFirstName() + " " + parent.getLastName() + " as the " + type + " .");
        System.out.println("--------------------------------------------------------");
        input.nextLine();
        return parent;
    }

}
