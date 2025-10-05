package emily;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Class for eye color and genotype
 * Eye color is determined by multiple genes, but for simplicity, we'll use a model with two main genes, each with two alleles (think AaBb).
 * The "A" gene influences brown vs. blue eyes, and the "B" gene influences green vs. blue eyes.
 * In this program, we'll represent the eye color genotype with a two-digit number, composed of 2's, 3's, and 4's:
 *     (2 = homozygous recessive, 3 = heterozygous, 4 = homozygous dominant)
 * Each digit represents one of the two genes (A and B), with the first digit for gene A and the second for gene B.
 *     for example, a genotype of 34 would indicate:
 *          - the first digit '3' indicates heterozygous for gene A (Aa, brown eyes)
 *          - the second digit '4' indicates homozygous dominant for gene B (BB, no green influence)
 * The combination of these alleles results in a genotype, which maps to a specific eye color phenotype
 *     for the example above: 34 -> AaBB -> brown eyes
 * The eye color phenotypes and their corresponding genotypes are stored in a HashMap for easy lookup
 * The class includes methods for selecting eye color, generating a genotype based on the selected color, and randomizing eye color and genotype  
 */

public class Eyes {
    
    // attributes needed outside the class
    private String eyeColor;
    private int eyeColorGenotype;
    
    // attributes not needed outside the class
    private String[] eyeColors = {"black", "dark brown", "hazel", "brown", "amber", "green", "dark blue", "blue", "gray"};
    private int[] eyeColorGenotypes = {44,43,42,34,33,32,24,23,22};
    private HashMap<String, String> eyeColorMap = new HashMap<String, String>();{
        for (int i = 0; i < 9; i++) {
        eyeColorMap.put(String.valueOf(eyeColorGenotypes[i]), eyeColors[i]);
        }
    }

    // default constructor
    Eyes() {
        eyeColor = "purple";
        eyeColorGenotype = 0;
    }

    // getters
     public String getEyeColor(){
        return eyeColor;
    }
    public int getEyeColorGenotype(){
        return eyeColorGenotype;
    }

    // setters
    public void setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
    }
    public void setEyeColorGenotype(int eyeColorGenotype){
        this.eyeColorGenotype = eyeColorGenotype;
    }

    // methods for user-selected eye color
    public String selectEyeColor(Scanner input){
        System.out.println("""
                                Next, we're going to select their eye color.
                                
                                What color eyes does your person have? Select from the list below, or enter \"R\" to randomize:
                                ---------------------
                                Eye color options:
                                ---------------------
                                """);
        for (String color : eyeColors) {
            System.out.println("- " + color);
        }
        eyeColor = input.nextLine();
        return eyeColor;
    }

    // method to randomize eye color
    public String randomizeEyeColor() {
            eyeColor = Person.randomize(eyeColors,eyeColor);
            return eyeColor;
    }

    // use phenotype (value) to locate corresponding genotype (key)
    // both user-selected and randomized eye colors use the same method to get genotype
    public int generateEyeColorGenotype(){
        eyeColorGenotype = getKeyByValue(eyeColorMap, eyeColor);
        return eyeColorGenotype; 
    }

    // Helper method to get key by value from HashMap
    public int getKeyByValue(HashMap<String, String> map, String value) {
        for (String key : map.keySet()) {
            if (map.get(key).equalsIgnoreCase(value)) {
                return Integer.parseInt(key);
            }
        }
        return -1;
    }
}
