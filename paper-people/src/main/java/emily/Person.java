package emily;

import java.util.Scanner;

public class Person {

     // naming variables and array
    String firstName;
    String lastName;
    // initiate array of last names for randomization; to be replaced with external list eventually 
    String [] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
                            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};
    String randomName;

    // variables for sex
    String sex;
    String [] sexes = {"XX", "XY"};
    
    // variables for eye color
    String eyeColor;
    String[] eyeColors = {"black", "dark brown", "hazel", "brown", "amber", "green", "dark blue", "blue", "gray"};
    String eyeColorGeneString;
    String[] eyeColorGeneStrings = {"CCDD", "CCDd", "CCdd", "CcDD", "CcDd", "Ccdd", "ccDD", "ccDd", "ccdd"};
    String eyeColorGene1Allele;
    String[] eyeColorGene1Alleles = {"C", "c"};
    String eyeColorGene2Allele;
    String[] eyeColorGene2Alleles = {"D", "d"};


    //String hairColor;
    //String skinColor;
    //String freckles;

    // default constructor
    Person() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.sex = "XY";
        this.eyeColor = "light brown";
    }
    
    // overloaded constructor; not currently used
    Person(String firstName, String lastName, String sex, String eyeColor){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.eyeColor = eyeColor;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // method to get user input for last name or randomize
    public String getLastName(Scanner input){
        System.out.println("Give your person a last name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            lastName = randomLastName();
        }
        else {
            lastName = name;
        }
       return lastName;
    }

    // method to randomize last name from array
    public String randomLastName(){
        int randomIndex = (int)(Math.random() * lastNames.length);
        lastName = lastNames[randomIndex];
        return lastName; 
    }

    // method to obtain a random sex
    public String getRandomSex(){
        int randomIndex = (int)(Math.random() * sexes.length);
        sex = sexes[randomIndex];
        return sex;}

    //code for eye genetics
    public String getEyeColor(){
        return eyeColor;
    }
    public String setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
        return eyeColor;
    }


    @Override
    public String toString() {
        return "Person{name='" + firstName + " " + lastName + "'}";
    }
}
