package emily;

public class Person {

     // instance variables
    String firstName;
    String lastName;
    String randomName;
    String sex;
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

    public String randomName(){
        return randomName;
    }

    @Override
    public String toString() {
        return "Person{name='" + firstName + " " + lastName + "'}";
    }
}
