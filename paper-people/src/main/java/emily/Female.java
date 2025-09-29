package emily;

import java.util.Scanner;

public class Female extends Person{

    final String sex = "XX";
    String[] femaleNames = {"Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen",
                            "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily"};
    
    Female(){
        firstName = "Eve";
        this.lastName = "Paper";
        Object Eyes;
        Object Hair;
    }

    Female(String firstName,String lastName,String sex,Object Eyes,Object Hair){
        this.firstName = firstName;
        this.lastName = lastName;
        sex = "XX";
        this.Eyes = Eyes;
        this.Hair = Hair;
    }

    public void setEyes(Object Eyes){
        this.Eyes = Eyes;
    }

    public void setHair(Object Hair){
        this.Hair = Hair;
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



