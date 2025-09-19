package emily;

import java.util.Scanner;

public class Female extends Person{

    String femaleName;
    String[] femaleNames = {"Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen",
                            "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily"};
    
    Female(){
        this.firstName = femaleName;
        this.lastName = "Doe";
        this.sex = "XX";
    }

    public void setFemaleName(String femaleName){
        this.femaleName = femaleName;
    }

    public String getFemaleName(Scanner input){
        System.out.println("Enter her first name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
            if (name.equalsIgnoreCase("R")) {
                femaleName = randomName();
            }
            else {
                femaleName = name;
            }
       System.out.println("Her first name is " + femaleName + ".");
       return femaleName;
    } 

    public String randomName(){
        int randomIndex = (int)(Math.random() * femaleNames.length);
        firstName = femaleNames[randomIndex];
        return firstName;   
    }

}



