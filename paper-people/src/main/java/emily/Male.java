package emily;

import java.util.Scanner;

public class Male extends Person{

    final String sex = "XY";
    String[] maleNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", 
                        "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth"};
    
    Male(){
        firstName = "";
        this.lastName = "";
        hairColor = "";
        hairColorGeneString = "";
    }

    Male(String firstName,String lastName,String sex,Object Eyes,String hairColor,String hairColorGeneString){
        this.firstName = firstName;
        this.lastName = lastName;
        sex = "XY";
        this.Eyes = Eyes;
        this.hairColor = hairColor;
        this.hairColorGeneString = hairColorGeneString;
    }

    public String getMaleName(Scanner input){
        System.out.println("Your person is a man. Give him a first name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
            if (name.equalsIgnoreCase("R")) {
                firstName = randomize(maleNames,firstName);
            }
            else {
                firstName = name;
            }
       System.out.println("His first name is " + firstName + ".");
       return firstName;
    } 
}



