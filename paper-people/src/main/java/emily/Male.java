package emily;

import java.util.Scanner;

public class Male extends Person{

    String[] maleNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", 
                        "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth"};
    
    Male(){
        firstName = "JOHN";
        lastName = "DOE";
        sex = "XY";
        eyes = super.eyes;
        hair = super.hair;
    }

    Male(String firstName,String lastName,String sex,Eyes eyes,Hair hair){
        this.firstName = firstName;
        this.lastName = lastName;
        sex = "XY";
        eyes = super.eyes;
        hair = super.hair;
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



