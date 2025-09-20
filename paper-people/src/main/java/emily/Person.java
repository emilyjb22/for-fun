package emily;

import java.util.Scanner;

public class Person {

     // variables and array for names
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

    // variables for hair color
    String hairColor;
    String [] hairColors = {"black", "black-brown", "dark brown", "brown", "auburn", "red", "dark blonde", "blonde", "strawberry blonde", "white"};
    String hairColorGeneString;
    String[] hairColorGeneStrings = {"AABBRR", "AABBRr", "AABBrr", "AABbRR", "AABbRr", "AABbrr", "AAbbRR", "AAbbRr", "AAbbrr", "AaBBRR", "AaBBRr", "AaBBrr", 
                                    "AaBbRR", "AaBbRr", "AaBbrr", "AabbRR", "AabbRr", "Aabbrr", "aaBBRR", "aaBBRr", "aaBBrr", "aaBbRR", "aaBbRr", "aaBbrr", "aabbRR", "aabbRr", "aabbrr"};
    String hairColorGene1Allele;
    String[] hairColorGene1Alleles = {"A", "a"};
    String hairColorGene2Allele;
    String[] hairColorGene2Alleles = {"B", "b"};
    String hairColorGene3Allele;
    String[] hairColorGene3Alleles = {"R", "r"};

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
/*
 * Code pertaining to name generation and randomization
 */
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

/*
 * Code pertaining to sex generation and randomization
 */
    public String getRandomSex(){
        int randomIndex = (int)(Math.random() * sexes.length);
        sex = sexes[randomIndex];
        return sex;}

/*
 * Code pertaining to eye color generation and randomization
 */
    public String getEyeColor(Scanner input){
        System.out.println("""
                                Next, we're going to select their eye color.
                                
                                What color eyes does your person have? Select from the list below, or enter \"R\" to randomize:
                                ---------------------
                                Eye color options:
                                ---------------------
                                """);
        // print list of eye colors for user to select from
        for (String color : eyeColors) {
            System.out.println("- " + color);
        }
        eyeColor = input.nextLine();
        if (eyeColor.equalsIgnoreCase("R")) {
            eyeColor = randomEyeColor();
        }
        System.out.println(firstName + " has " + eyeColor + " eyes.");
        return eyeColor; 
    }

    public String setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
        return eyeColor;
    }

    public String randomEyeColor(){
        int randomIndex = (int)(Math.random() * eyeColors.length);
        eyeColor = eyeColors[randomIndex];
        return eyeColor; 
    }

/*
 * Code pertaining to hair color generation and randomization
 */


    @Override
    public String toString() {
        return "Person{name='" + firstName + " " + lastName + "'}";
    }
}
