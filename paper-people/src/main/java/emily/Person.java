package emily;

import java.util.Scanner;

public class Person {

     // instance variables
    String firstName;
    String lastName;
    String randomName;
    String sex;
    String [] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
                            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};  
    //String hairColor;
    //String eyeColor;
    //String skinColor;
    //String freckles;

    // default constructor. Would eventually need to pull random name from an external list...?
    Person() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.sex = "XY";
    }
    
    Person(String firstName, String lastName, String sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(Scanner input){
        System.out.println("Enter his last name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            lastName = randomLastName();
        }
        else {
            lastName = name;
        }
       return lastName;
    }

    public String randomLastName(){
        int randomIndex = (int)(Math.random() * lastNames.length);
        lastName = lastNames[randomIndex];
        return lastName; 
    }

    @Override
    public String toString() {
        return "Person{name='" + firstName + " " + lastName + "'}";
    }
}
