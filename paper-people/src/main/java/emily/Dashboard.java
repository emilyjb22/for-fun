package emily;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import emily.people.Female;
import emily.people.Male;
import emily.people.Person;
import emily.utils.Randomize;

public class Dashboard {

    private static final List<Male> allMales = new ArrayList<>();
    private static final List<Female> allFemales = new ArrayList<>();

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
               4.  View Allele Frequencies
               5.  Exit
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

    public List<Male> getAllMales() {
        return allMales;
    }

    public List<Female> getAllFemales() {
        return allFemales;
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
        String phenotype = Randomize.random(phenoList);
        return phenotype;
    }

    // choose a parent from population list
    public static Person selectParent(String type, List<? extends Person> parentList, Scanner input) {
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

    public static void addToPopulation(Person person, Scanner input) {
        System.out.println("Do you want to save this person to your population? (Y/N)");
        String save = input.nextLine();

        if (save.equalsIgnoreCase("Y")) {
            savePerson(person);
        } else {
            System.out.println("Person not saved.");
        }
    }

    public static void savePerson(Person person) {
        if (person.isMale()) {
            allMales.add((Male) person);
        } else {
            allFemales.add((Female) person);
        }
        System.out.println("Great! " + person.getFirstName() + " has been added to your population.");
        System.out.println(person.toString());
    }

    

}
