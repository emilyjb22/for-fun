package emily.people;

import java.util.Scanner;

import emily.traits.Eyes;
import emily.traits.Hair;
import emily.utils.Ancillary;
import emily.utils.Randomize;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    private static String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
            "Rodriguez",
            "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin" };
    protected boolean isMale;
    protected Eyes eyes;
    protected Hair hair;
    protected Male dad;
    protected Female mom;

    public Person() {
        this.eyes = new Eyes();
        this.hair = new Hair();
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getLastNames() {
        return lastNames;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Male getDad() {
        return dad;
    }

    public void setDad(Male dad) {
        this.dad = dad;
    }

    public Female getMom() {
        return mom;
    }

    public void setMom(Female mom) {
        this.mom = mom;
    }

    // methods for naming
    public static String makeName(Scanner input, String[] names, String message) {
        System.out.println(message);
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            name = Randomize.random(names);
        }
        name = Ancillary.formatName(name);
        return name;
    }

    public static String makeFirstName(Scanner input, boolean isMale, Male dad, Female mom) {
        String name = isMale ? makeName(input, dad.getMaleNames(),
                "Give him a first name, or enter \"R\" to randomize: ")
                : makeName(input, mom.getFemaleNames(),
                        "Give her a first name, or enter \"R\" to randomize: ");
        return name;
    }

    public static String makeLastName(Scanner input) {
        String surname = makeName(input, lastNames,
                "Give them a last name, or enter \"R\" to randomize: ");
        return surname;
    }

    public static boolean generateIsMale(Scanner input) {
        boolean isMale = true;
        String selection = "";

        while (!selection.equals("R") && !selection.equals("XX") && !selection.equals("XY")) {
            System.out.println(
                    "Is your person male (XY) or female (XX)? Type your answer or type \"R\" to randomize.");
            selection = input.nextLine().toUpperCase();

            if (selection.equals("R"))
                isMale = Math.random() < 0.5;
            else {
                switch (selection) {
                    case "XY" -> {
                        isMale = true;
                    }
                    case "XX" -> {
                        isMale = false;
                    }
                    default -> System.out.println("Invalid entry. Please try again.");
                }
            }
        }
        return isMale;
    }

    // methods for displaying person info
    public static void printPerson(Person person) {
        System.out.println("Great! " + person.getFirstName() + " " + person.getLastName() + " has " +
                person.eyes.getPhenotype() + " eyes (" + person.eyes.getGenotype() + ")" +
                " and " + person.hair.getPhenotype() + " hair (" + person.hair.getGenotype() + ").");
    }

    @Override
    public String toString() {
        return "{ name: " + firstName + " " + lastName +
                ", eyes: " + eyes.getPhenotype() + " (" + eyes.getGenotype() + ")" +
                ", hair: " + hair.getPhenotype() + " (" + hair.getGenotype() + ")" +
                ", Dad: " + (dad != null ? dad.getFirstName() + " " + dad.getLastName() : "Unknown") +
                ", Mom: " + (mom != null ? mom.getFirstName() + " " + mom.getLastName() : "Unknown") +
                " }";
    }
}
