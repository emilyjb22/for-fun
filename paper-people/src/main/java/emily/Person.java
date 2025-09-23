package emily;

import java.util.Scanner;
import java.util.HashMap;
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

    // variables for sex
    static String sex;
    static String[] sexes = {"XX", "XY"};
    
    // variables for eye color
    String eyeColor;
    String[] eyeColors = {"black", "dark brown", "hazel", "brown", "amber", "green", "dark blue", "blue", "gray"};
    String eyeColorGenotype;
    String[] eyeColorGenotypes = {"CCDD", "CCDd", "CCdd", "CcDD", "CcDd", "Ccdd", "ccDD", "ccDd", "ccdd"};
    String eyeColorGene1Allele;
    String[] eyeColorGene1Alleles = {"C", "c"};
    String eyeColorGene2Allele;
    String[] eyeColorGene2Alleles = {"D", "d"};

    // variables for hair color
    String hairColor;
    String hairColorGeneString;
    String [] hairColors = {"black","black-brown","dark brown","brown", "light brown", "auburn", "red", "blonde", "strawberry blonde", "white"};
    String [] blackHairGenotypes = {"AABBRR","AABBRr","AABBrR","AABBrr"};
    String [] blackBrownHairGenotypes = {"AABbRR","AAbBRR","AABbRr","AABbrR","AAbBRr","AAbBrR","AABbrr","AAbBrr"};
    String [] darkBrownHairGenotypes = {"AAbbRR","AAbbRr","AAbbrR","AAbbrr"};
    String [] brownHairGenotypes = {"AaBBRR","aABBRR","AaBBRr","AaBBrR","aABBRr","aABBrR","AaBBrr","aABBrr","AaBbRR","AabBRR","aABbRR","aAbBRR","AaBbRr","AaBbrR","AabBRr","AabBrR","aABbRr","aABbrR","aAbBRr","aAbBrR"};
    String [] lightBrownHairGenotypes = {"AaBBrr","aABBRR","AaBbrr","AabBrr","aABbrr","aAbBrr","Aabbrr","aAbbrr"};
    String [] auburnHairGenotypes = {"AabbRR","aAbbRR","AabbRr","AabbrR","aAbbRr","aAbbrR"}; 
    String [] blondeHairGenotypes = {"aaBBRR","aaBBRr","aaBBrR","aaBBrr","aaBbrr","aabBrr"};
    String [] strawberryBlondeHairGenotypes = {"aabbRR","aabbRr","aabbrR"};
    String [] redHairGenotypes = {"aabbRR","aabbRr","aabbrR"};
    String whiteHairGenotype = "aabbcc";
    String hairColorGene1Allele;
    String[] hairColorGene1Alleles = {"A", "a"};
    String hairColorGene2Allele;
    String[] hairColorGene2Alleles = {"B", "b"};
    String hairColorGene3Allele;
    String[] hairColorGene3Alleles = {"R", "r"};

    //String skinColor;
    //String freckles;

    // default constructor
    Person() {  
        this.firstName = "John";
        this.lastName = "Doe";
        Person.sex = "XY";
        this.eyeColor = "light brown";
    }
    
    // overloaded constructor; not currently used
    Person(String firstName, String lastName, String sex, String eyeColor){
        this.firstName = firstName;
        this.lastName = lastName;
        Person.sex = sex;
        this.eyeColor = eyeColor;
    }
/*
 * Code pertaining to name generation and randomization
 */
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
 * Code pertaining to eye color generation and randomization
 */
    public String getEyeColor(Scanner input){
        System.out.println("""
                                Next, we're going to select their eye color.
                                
                                What color eyes does your person have? Select from the list below, or enter \"R\" to randomize:
                                ---------------------
                                Eye color options:
                                ---------------------
                                """);
        // print list of eye colors for user to select from
        for (String color : eyeColors) {
            System.out.println("- " + color);
        }
        eyeColor = input.nextLine();

        // use arrays to create HashMap of genotype -> phenotype pairs
        var eyeColorMap = new HashMap<String,String>();
            for (int i = 0; i < 9; i++) {
            eyeColorMap.put(eyeColorGenotypes[i],eyeColors[i]);
            }

        // randomly select eye color phenotype
        if (eyeColor.equalsIgnoreCase("R")) {
            eyeColor = randomize(eyeColors,eyeColor);
        }

        // use phenotype (value) to locate corresponding genotype (key)
        // save phenotype as "eyeColor" and genotype as "eyeColorGenotype"
        eyeColorGenotype = getKeyByValue(eyeColorMap, eyeColor);

        System.out.println(firstName + " has " + eyeColor + " eyes. Their genotype is " + eyeColorGenotype);
        return eyeColor; 
    }

    public String setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
        return eyeColor;
    }

/*
 * Code pertaining to hair color generation and randomization
 */

    public String getHairColor(Scanner input){
        var hairColorMap = new HashMap<String,String>();
            arrayToHashMap(blackHairGenotypes,hairColorMap,"black");
            arrayToHashMap(blackBrownHairGenotypes,hairColorMap,"black-brown");
            arrayToHashMap(darkBrownHairGenotypes,hairColorMap,"dark brown");
            arrayToHashMap(brownHairGenotypes,hairColorMap,"brown");
            arrayToHashMap(lightBrownHairGenotypes,hairColorMap,"light brown");
            arrayToHashMap(auburnHairGenotypes,hairColorMap,"auburn");
            arrayToHashMap(blondeHairGenotypes,hairColorMap,"blonde");
            arrayToHashMap(strawberryBlondeHairGenotypes,hairColorMap,"strawberry blonde");
            arrayToHashMap(redHairGenotypes,hairColorMap,"red");
            hairColorMap.put(whiteHairGenotype,"white");

        System.out.println("""
                                Now, we're going to select their hair color.
                                
                                What color hair does your person have? Select from the list below, or enter \"R\" to randomize:
                                ---------------------
                                Hair color options:
                                ---------------------
                                """);
        // print list of hair colors for user to select from
        for (String color : hairColors) {
            System.out.println("- " + color);
        }
        hairColor = input.nextLine();
         if (hairColor.equalsIgnoreCase("R")) {
            String hairColorGeneString = getHairColorGeneString();
            System.out.println(hairColorGeneString);
            hairColor = hairColorMap.get(hairColorGeneString);
            this.hairColorGeneString=hairColorGeneString;
        }
        else{

        };

        System.out.println(firstName + " has " + hairColor + " hair. Their genotype is " + hairColorGeneString + ".");
        return hairColorGeneString; 
    }

    public String setHairColor(String hairColor){
        this.hairColor = hairColor;
        return hairColor;
    }

    public String getHairColorGeneString(){
        String hairColorGeneString = randomHairColorGene1String() + randomHairColorGene2String() + randomHairColorGene3String();
        return hairColorGeneString;
    }

    public String randomHairColorGene1String(){
        String allele1 = randomize(hairColorGene1Alleles,hairColorGene1Allele);
        String allele2 = randomize(hairColorGene1Alleles,hairColorGene1Allele);
        String hairColorGene1String = allele1 + allele2;
        return hairColorGene1String;
    }

public String randomHairColorGene2String(){
        String allele1 = randomize(hairColorGene2Alleles,hairColorGene2Allele);
        String allele2 = randomize(hairColorGene2Alleles,hairColorGene2Allele);
        String hairColorGene2String = allele1 + allele2;
        return hairColorGene2String;
    }

    public String randomHairColorGene3String(){
        String allele1 = randomize(hairColorGene3Alleles,hairColorGene3Allele);
        String allele2 = randomize(hairColorGene3Alleles,hairColorGene3Allele);
        String hairColorGene3String = allele1 + allele2;
        return hairColorGene3String;
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

// method to get key from value
// https://stackoverflow.com/questions/1383797/java-hashmap-how-to-get-key-from-value
public static <K, V> K getKeyByValue(HashMap<K, V> hashMap, V value) {
    for (Map.Entry<K, V> entry : hashMap.entrySet()) {
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null;
}

    @Override
    public String toString() {
        return "Person{name='" + firstName + " " + lastName + "'}";
    }
}
