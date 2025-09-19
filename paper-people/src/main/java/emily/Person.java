package emily;

import java.util.Scanner;

public class Person {

     // instance variables
    String firstName;
    String lastName;
    // initiate array of last names for randomization; to be replaced with external list eventually 
    String [] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
                            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};
    String randomName;
    String sex;
    String [] sexes = {"XX", "XY"};  
    //String hairColor;
    //String eyeColor;
    //String skinColor;
    //String freckles;

    // default constructor
    Person() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.sex = "XY";
    }
    
    // overloaded constructor; not currently used
    Person(String firstName, String lastName, String sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
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

    public String getRandomSex(){
        int randomIndex = (int)(Math.random() * sexes.length);
        sex = sexes[randomIndex];
        return sex;}

    @Override
    public String toString() {
        return "Person{name='" + firstName + " " + lastName + "'}";
    }
}
