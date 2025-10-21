package emily.traits;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import emily.people.Person;

/**
 * Class representing eye color and genotype.
 *
 * Overview:
 * - Eye color is determined by multiple genes, but for simplicity,
 * this model uses two main genes (A and B), each with two alleles.
 *
 * Genotype representation:
 * - Each gene is represented by a digit:
 * 2 = homozygous recessive
 * 3 = heterozygous
 * 4 = homozygous dominant
 * - The first digit = gene A (brown vs. blue)
 * - The second digit = gene B (green vs. blue)
 * - Example: genotype 34
 * - '3' → Aa (heterozygous for gene A, brown influence)
 * - '4' → BB (homozygous dominant for gene B, no green influence)
 *
 * Phenotype mapping:
 * - The combination of digits maps to a specific eye color:
 * 34 → AaBB → brown eyes
 * - Mappings are stored in a HashMap for easy lookup.
 *
 * Methods:
 * - selectEyeColor(Scanner input) → allows user to choose eye color
 * - randomizeEyeColor() → picks a random eye color
 * - generateEyeColorGenotype() → generates genotype for current eye color
 */

public class Eyes extends Trait {

    private static final List<String> EYE_COLORS = Collections.unmodifiableList(List.of(
            "black", "dark brown", "hazel", "brown", "amber", "green", "dark blue", "blue", "gray"));

    private static final Map<String, String> EYE_COLOR_MAP;

    static {
        HashMap<String, String> eyeColorMap = new HashMap<>();
        int[] eyeColorGenotypes = { 44, 43, 42, 34, 33, 32, 24, 23, 22 };
        for (int i = 0; i < EYE_COLORS.size(); i++) {
            eyeColorMap.put(String.valueOf(eyeColorGenotypes[i]), EYE_COLORS.get(i));
        }
        // Wrap the map to make it unmodifiable
        EYE_COLOR_MAP = Collections.unmodifiableMap(eyeColorMap);
    }

    // attributes needed outside the class
    private String eyeColor;
    private int eyeColorGenotype;

    // default constructor
    public Eyes() {
        this("purple", 0);
    }

    Eyes(String eyeColor, int eyeColorGenotype) {
        this.eyeColor = eyeColor;
        this.eyeColorGenotype = eyeColorGenotype;
    }

    // getters
    public String getEyeColor() {
        return eyeColor;
    }

    public int getEyeColorGenotype() {
        return eyeColorGenotype;
    }

    public static Map<String, String> getEyeColorMap() {
        return EYE_COLOR_MAP;
    }

    // setters
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setEyeColorGenotype(int eyeColorGenotype) {
        this.eyeColorGenotype = eyeColorGenotype;
    }

    // methods for user-selected eye color
    // need to validate user entry
    // adding to parent class
    /*
     * public String selectEyeColor(Scanner input){
     * System.out.println("""
     * Next, we're going to select their eye color.
     * 
     * What color eyes does your person have? Select from the list below, or enter
     * \"R\" to randomize:
     * ---------------------
     * Eye color options:
     * ---------------------
     * """);
     * for (String color : EYE_COLORS) {
     * System.out.println("- " + color);
     * }
     * eyeColor = input.nextLine();
     * return eyeColor;
     * }
     */

    // method to randomize eye color
    public String randomizeEyeColor() {
        eyeColor = Person.randomize(EYE_COLORS, eyeColor);
        return eyeColor;
    }

    // use phenotype (value) to locate corresponding genotype (key)
    // both user-selected and randomized eye colors use the same method to get
    // genotype
    // adding to parent class
    /*
     * public int generateEyeColorGenotype(){
     * eyeColorGenotype = getKeyByValue(EYE_COLOR_MAP, eyeColor);
     * return eyeColorGenotype;
     * }
     * 
     * // Helper method to get key by value from HashMap
     * public int getKeyByValue(Map<String, String> map, String value) {
     * for (String key : map.keySet()) {
     * if (map.get(key).equalsIgnoreCase(value)) {
     * return Integer.parseInt(key);
     * }
     * }
     * return -1;
     * }
     */
}
