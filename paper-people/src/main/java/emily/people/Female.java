package emily.people;

import java.util.Scanner;

import emily.traits.Eyes;
import emily.traits.Hair;

public class Female extends Person{

    public String[] femaleNames = {"Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen",
                            "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily"};
    
    public Female(){
        firstName = "JANE";
        lastName = "DOE";
        sex = "XX";
        eyes = super.eyes;
        hair = super.hair;
    }

    public Female(String firstName,String lastName,String sex,Eyes eyes,Hair hair,Male dad,Female mom){
        this.firstName = firstName;
        this.lastName = lastName;
        sex = "XX";
        this.eyes = eyes;
        this.hair = hair;
        this.dad = dad;
        this.mom = mom;
    }

    public String getFemaleName(Scanner input){
        System.out.println("Your person is a woman. Give her a first name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
            if (name.equalsIgnoreCase("R")) {
                firstName = randomize(femaleNames,firstName);
            }
            else {
                firstName = name;
            }
       System.out.println("Her first name is " + firstName + ".");
       return firstName;
    } 
}



