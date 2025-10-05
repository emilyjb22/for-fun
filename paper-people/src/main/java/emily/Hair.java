package emily;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * Class for hair color and genotype
 * Genetics for hair color is polygenic, meaning multiple genes contribute to the phenotype. Real-world hair color genetics is complex and not fully understood,
 * but for the purposes of this program, we'll simplify it to a model involving three genes, each with two alleles (think AaBbCc).
 * Approximately, the "A" gene influences very dark hair, the "B" gene influences middle tone hair, and the "C" gene influences red hair.
 * A and B are codominant, and both are partially dominant over C.
 * In this program, we'll represent the hair color genotype with a three-digit number, composed of 2's, 3's, and 4's:
 *     (2 = homozygous recessive, 3 = heterozygous, 4 = homozygous dominant)
 * Each digit represents one of the three genes (A, B, and C), with the first digit for gene A, the second for gene B, and the third for gene C.
 *     for example, a genotype of 243 would indicate:
 *          - the first digit '2' indicates homozygous recessive for gene A (aa, non-black hair)
 *          - the second digit '4' indicates homozygous dominant for gene B (BB, brown hair)
 *          - the third digit '3' indicates heterozygous for gene C (Cc, some red influence)
 * The combination of these alleles results in a genotype, which maps to a specific hair color phenotype
 *     for the example above: 243 -> aaBBCc -> middle tone hair with some red influence (in this program, will be classified as "blonde")
 * The hair color phenotypes and their corresponding genotypes are stored in a HashMap for easy lookup
 * The class includes methods for selecting hair color, generating a genotype based on the selected color, and randomizing hair color and genotype  
 */

public class Hair {

    // variables needed outside the class
    private String hairColor;
    private int hairColorGenotype;

    // variables not needed outside the class
    private String hairColorGeneString;
    private String [] hairColors = {"black","black-brown","dark brown","brown", "light brown", "auburn", "red", "blonde", "strawberry blonde", "white"};
    private int [] blackHairGenotypes = {444,443,442};
    private int [] blackBrownHairGenotypes = {434,433,432};
    private int [] darkBrownHairGenotypes = {424,423,422};
    private int [] brownHairGenotypes = {344,343,334,333};
    private int [] lightBrownHairGenotypes = {342,332,322};
    private int [] auburnHairGenotypes = {324,323}; 
    private int [] blondeHairGenotypes = {244,243,242,232};
    private int [] strawberryBlondeHairGenotypes = {234,233};
    private int [] redHairGenotypes = {224,223};
    private String whiteHairGenotype = "222";
    private String allele;
    private String [] alleles = {"2","3","3","4"};
    private HashMap<String, String> hairColorMap = new HashMap<String,String>();

    // default constructor
    Hair(){
        hairColor = "purple";
        hairColorGeneString = "0";
        hairColorGenotype = 0;
    }

    // getters
    // idk if I need setters yet
    public String getHairColor(){
        return hairColor;
    }
    public int getHairColorGenotype(){
        return hairColorGenotype;
    }

    // methods for hair color HashMap (genotype (key) to phenotype (value) mapping)
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

    // methods for user-selected hair color
    // get user input for hair color
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

    //search HashMap for all associated genotypes for user-selected hairColor, make a set, then an array, for all associated genotypes,
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

    // methods for random hair color generation

    // randomize from alleles array three times and concatenate into a string, parse string into int
    // resulting value is the genotype (as a string)
        public String randomizeHair(){
            hairColorGeneString = Person.randomize(alleles,allele) + Person.randomize(alleles,allele) + Person.randomize(alleles,allele);
            return hairColorGeneString;
        }

    // parse hairColorGeneString into an int and save as hairColorGenotype
        public int makeHairColorGenotype(){
            hairColorGenotype = Integer.parseInt(hairColorGeneString);
            return hairColorGenotype;
        }

    // use generated genotype (key) to search HashMap for hairColor (value), save hairColor
        public String randomizeHairColor(){
            hairColor = hairColorMap.get(hairColorGeneString);
            return hairColor;
        }
}

