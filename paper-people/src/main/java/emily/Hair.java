package emily;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Hair {

    String hairColor;
    //hairColorGeneSting
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

    //check whether int is converting to string
    public void arrayToHashMap(int[] array, HashMap<String, String> hashMap, String trait){
        int i = 0;
        for (int genotype : array)
        hashMap.put(String.valueOf(array[i++]), trait);
    }

    public String promptHairColor(Scanner input){

        HashMap<String, String> hairColorMap = new HashMap<String,String>();
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
        return hairColor;
    }

    public int selectHairColor (HashMap<String,String> hairColorMap){
        Set<String> possibleGenotypesSet = Person.getKeysByValue(hairColorMap, hairColor);
            String possibleGenotypes[] = possibleGenotypesSet.toArray(new String[0]);
            String hairColorGeneString = Person.randomize(possibleGenotypes, hairColorGeneString);
            try {
                hairColorGenotype = Integer.parseInt(hairColorGeneString);
            }
            catch (NumberFormatException e) {
                System.err.println("Invalid number format for parseInt: " + e.getMessage());
            }
            return hairColorGenotype;
    }

    public int randomizeHairColor(){
        generateRandomGenotype();
        hairColor = hairColorMap.get(hairColorGenotype);
      
            
            this.hairColorGeneString=hairColorGeneString;
    }

        // randomly generate genotype (randomly select alleles) and save as hairColorGenotype
        // match genotype to corresponding phenotype in HashMap, save phenotype as hairColor
        
         if (hairColor.equalsIgnoreCase("R")) {
            
        }
        else{
            Set<String> possibleHairColorGenotypesSet = getKeysByValue(hairColorMap, hairColor);
            String possibleHairColorGenotypes[] = possibleHairColorGenotypesSet.toArray(new String[0]);
            hairColorGeneString = randomize(possibleHairColorGenotypes, hairColorGeneString);
        }

        System.out.println(firstName + " has " + hairColor + " hair. Their genotype is " + hairColorGeneString + ".");
        System.out.println("--------------------------------------------------------");
        return hairColorGeneString; 
    }

    public String setHairColor(String hairColor){
        this.hairColor = hairColor;
        return hairColor;
    }

    public String generateRandomGenotype(){
        String hairColorGeneString = Person.randomize(alleles,allele) + Person.randomize(alleles,allele) + Person.randomize(alleles,allele);
        return hairColorGeneString;
    }
