package emily;

import java.util.Scanner;

public class Male extends Person{

    String[] maleNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", 
                        "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth"};
    String maleName;
    
    Male(){
        this.firstName = maleName;
        this.lastName = "Doe";
        this.sex = "XY";
    }

    public void setMaleName(String maleName){
        this.maleName = maleName;
    }

    /**
     * @param input
     * @return
     */
    public String getMaleName(Scanner input){
        System.out.println("Enter his first name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
            if (name.equalsIgnoreCase("R")) {
                maleName = randomName();
            }
            else {
                maleName = name;
            }
       System.out.println("His first name is " + maleName + ".");
       return maleName;
    } 

    public String randomName(){
        int randomIndex = (int)(Math.random() * maleNames.length);
        firstName = maleNames[randomIndex];
        return firstName;   
    }

}



