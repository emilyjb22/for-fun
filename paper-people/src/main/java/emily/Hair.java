package emily;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Hair {

    String hairColor;
    String hairColorGeneString;
    int hairColorGenotype;
    String [] hairColors = {"black","black-brown","dark brown","brown", "light brown", "auburn", "red", "blonde", "strawberry blonde", "white"};
    int [] blackHairGenotypes = {444,443,442};
    int [] blackBrownHairGenotypes = {434,433,432};
    int [] darkBrownHairGenotypes = {424,423,422};
    int [] brownHairGenotypes = {344,343,334,333};
    int [] lightBrownHairGenotypes = {342,332,322};
    int [] auburnHairGenotypes = {324,323}; 
    int [] blondeHairGenotypes = {244,243,242,232};
    int [] strawberryBlondeHairGenotypes = {234,233};
    int [] redHairGenotypes = {224,223};
    String whiteHairGenotype = "222";
    String allele;
    String [] alleles = {"2","3","3","4"};
    HashMap<String, String> hairColorMap = new HashMap<String,String>();

    // turn all the int genotype arrays into a single HashMap for retrieving genotype/phenotype pairs
    public void arrayToHashMap(int[] array, HashMap<String, String> hashMap, String trait){
        for (int genotype : array)
        hashMap.put(String.valueOf(genotype), trait);
    }

    public void makeHashMap(){
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
    }

    //user manually selects a hair color, saves user selection
    public String selectHairColor(Scanner input){
        System.out.println("""
                                Now, we're going to select their hair color.
                                
                                What color hair does your person have? Select from the list below:
                                ---------------------
                                Hair color options:
                                ---------------------
                                """);
        for (String color : hairColors) {
            System.out.println("- " + color);
        }
        hairColor = input.nextLine();
        return hairColor;
    }

    //search HashMap for all associated genotypes for user-selected hairColor, make a set then ann array for all associated genotypes,
    //then randomly select one of the genotypes from the array, parse the string back to an int value, and save int as hairColorGenotype
    public int generateHairColorGenotype (){
        Set<String> possibleGenotypesSet = Person.getKeysByValue(hairColorMap, hairColor);
            String possibleGenotypes[] = possibleGenotypesSet.toArray(new String[0]);
            hairColorGeneString = Person.randomize(possibleGenotypes, hairColorGeneString);
            try {
                hairColorGenotype = Integer.parseInt(hairColorGeneString);
            }
            catch (NumberFormatException e) {
                System.err.println("Invalid number format for parseInt: " + e.getMessage());
            }
            return hairColorGenotype;
    }

//randomize from alleles array three times and concatenate into a string, parse string into int
//resulting value is the genotype
    public String randomizeHair(){
        String hairColorGeneString = Person.randomize(alleles,allele) + Person.randomize(alleles,allele) + Person.randomize(alleles,allele);
        return hairColorGeneString;
}

    public int getHairColorGenotype(){
        hairColorGenotype = Integer.parseInt(hairColorGeneString);
        return hairColorGenotype;
}

//use generated genotype (key) to search HashMap for hairColor (value), save hairColor
    public String randomizeHairColor(){
        hairColor = hairColorMap.get(hairColorGeneString);
        return hairColor;
    }
}

