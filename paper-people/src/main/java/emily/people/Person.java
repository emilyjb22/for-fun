package emily.people;

import java.util.Scanner;

import emily.traits.Eyes;
import emily.traits.Hair;
import emily.RandomUtils;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez",
            "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin" };
    protected String sex;
    protected String[] sexes = { "XY", "XX" };
    protected Eyes eyes;
    protected Hair hair;
    protected Male dad;
    protected Female mom;

    public Person() {
        this.eyes = new Eyes();
        this.hair = new Hair();
    }

    public String makeLastName(Scanner input) {
        System.out.println("Give your person a last name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            lastName = RandomUtils.random(lastNames);
        } else {
            lastName = name;
        }
        return lastName;
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

    public void setLastName(String name) {
        this.lastName = name;
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

    @Override
    public String toString() {
        return "{ name: " + firstName + " " + lastName +
                ", eyes: " + eyes.getEyeColor() +
                ", hair: " + hair.getHairColor() +
                ", Dad: " + (dad != null ? dad.getFirstName() : "Unknown") +
                ", Mom: " + (mom != null ? mom.getFirstName() : "Unknown") +
                " }";
    }
}
