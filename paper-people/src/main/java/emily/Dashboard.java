package emily;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import emily.people.Person;
import emily.util.RandomizeUtils;

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

    public static String traitSelectMenu(String pronoun, String traitType) {
        return """

                --------------------------------------------------------
                How do you want to determine %s %s?

                --------------------------------------------------------

                    1. Choose %s %s manually
                    2. Randomize %s %s

                --------------------------------------------------------
                Please enter "1" or "2" to proceed

                """.formatted(
                pronoun,
                traitType,
                pronoun,
                traitType,
                pronoun,
                traitType);
    }

    // User selects phenotype from printed list
    public static String selectPhenotype(String selectionMenu, Scanner input, List<String> phenoList) {
        System.out.println(selectionMenu);
        for (String pheno : phenoList) {
            System.out.println("- " + pheno);
        }
        String phenotype = input.nextLine();
        return phenotype;
    }

    // Randomized phenotype from list (user selects "R")
    public String randomizePhenotype(List<String> phenoList) {
        String phenotype = RandomizeUtils.random(phenoList);
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
