package emily;

import java.util.Scanner;

public class Male extends Person{

    final String sex = "XY";
    String[] maleNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", 
                        "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth"};
    
    Male(){
        firstName = "";
        this.lastName = "";
    }

    Male(String firstName,String lastName,String sex,Object Eyes,Object Hair){
        this.firstName = firstName;
        this.lastName = lastName;
        sex = "XY";
        this.Eyes = Eyes;
        this.Hair = Hair;
    }

    public void setEyes(Object Eyes){
        this.Eyes = Eyes;
    }

    public void setHair(Object Hair){
        this.Hair = Hair;
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



