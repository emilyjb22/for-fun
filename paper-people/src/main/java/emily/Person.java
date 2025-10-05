package emily;

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Person {

     // variables and array for names
    String firstName;
    String lastName;
    // initiate array of last names for randomization; to be replaced with external list eventually 
    String [] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
                            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};
    String randomName;

    // variables/objects for sex, eyes, hair
    static String sex;
    static String[] sexes = {"XX", "XY"};
    Eyes eyes;
    Hair hair;
   
    //String skinColor;
    //String freckles;

    // default constructor
    Person() {  
        firstName = "John";
        lastName = "Doe";
        sex = "XY";
        eyes = new Eyes();
        hair = new Hair();
    }
    
//Code pertaining to name generation and randomization
 
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // method to get user input for last name or randomize
    public String getLastName(Scanner input){
        System.out.println("Give your person a last name, or enter \"R\" to randomize: ");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("R")) {
            lastName = randomize(lastNames,lastName);
        }
        else {
            lastName = name;
        }
       return lastName;
    }

    /*
     * practical methods that I need to use frequently
     */

    // method to randomize EVERYTHING
    public static String randomize(String[] array, String thing){
        int randomIndex = (int)(Math.random() * array.length);
        thing = array[randomIndex];
        return thing;
    }

    // method to move array values into a hash map
    public void arrayToHashMap(String[] array, HashMap<String, String> hashMap, String trait){
        int i = 0;
        for (String genotype : array)
        hashMap.put(array[i++], trait);
    }

    // methods to get keys from values
    // https://stackoverflow.com/questions/1383797/java-hashmap-how-to-get-key-from-value
    // single key to single value
    public static <K, V> K getKeyByValue(HashMap<K, V> hashMap, V value) {
        for (Map.Entry<K, V> entry : hashMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    // multiple keys with same value
    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    //
    @Override
    public String toString() {
        String s;

            s = "{ ";
            s += "name: " + firstName + " " + lastName;
            s += ", ";
            s += "eye color: " + this.eyes.getEyeColor();
            s += ", ";
            s += "eye color genotype: " + this.eyes.getEyeGenotype();
            s += ", ";
            s += "hair color: " + this.hair.getHairColor();
            s += ", ";
            s += "hair color genotype: " + this.hair.getHairColorGenotype();
            s += " }";
            return s;
}
    }

