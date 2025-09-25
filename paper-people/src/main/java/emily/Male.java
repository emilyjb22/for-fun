package emily;

import java.util.Scanner;

public class Male extends Person{

    String[] maleNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", 
                        "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth"};
    
    Male(){
        firstName = "Adam";
        this.lastName = "Paper";
        Person.sex = "XY";
        eyeColor = "purple";
        eyeColorGenotype = "YyZz";
        hairColor = "rainbow";
        hairColorGeneString = "EeFfGg";
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



