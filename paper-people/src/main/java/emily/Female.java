package emily;

import java.util.Scanner;

public class Female extends Person{

    String[] femaleNames = {"Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen",
                            "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily"};
    
    Female(){
        firstName = "Eve";
        this.lastName = "Paper";
        Person.sex = "XX";
        Object Eyes;
        hairColor = "rainbow";
        hairColorGeneString = "EeFfGg";
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



