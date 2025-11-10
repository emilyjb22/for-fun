package emily.traits;

import java.util.Scanner;
import java.util.Set;

import emily.RandomUtils;
import emily.people.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Trait {

    // need variables
    int geneotype;
    String phenotype;
    String selectionMenu;
    int parentGeno = 333;

    /*
     * // possible babies
     * String[] bothHomozygousDominant = { "4" }; // AA x AA
     * String[] homozygousDominantByHeterozygous = { "4", "3" }; // AA x Aa
     * String[] homozygousDominantByHomozygousRecessive = { "3" }; // AA x aa
     * String[] bothHeterozygous = { "4", "3", "3", "2" }; // Aa x Aa
     * String[] heterozygousByHomozygousRecessive = { "3", "2" }; // Aa x aa
     * String[] bothHomozygousRecessive = { "2" }; // aa x aa
     * int[] parentCrosses = { 16, 12, 8, 9, 6, 4 };
     * 
     * // map of parent crosses (product of their individual alleles) to posstible
     * baby
     * // combinations (saved as String arrays)
     * private static HashMap<Integer, String[]> parentCrossMap = new
     * HashMap<Integer, String[]>();
     * {
     * int i = 0;
     * parentCrossMap.put(Integer.valueOf(parentCrosses[i]),
     * bothHomozygousDominant);
     * i++;
     * parentCrossMap.put(Integer.valueOf(parentCrosses[i]),
     * homozygousDominantByHeterozygous);
     * i++;
     * parentCrossMap.put(Integer.valueOf(parentCrosses[i]),
     * homozygousDominantByHomozygousRecessive);
     * i++;
     * parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHeterozygous);
     * i++;
     * parentCrossMap.put(Integer.valueOf(parentCrosses[i]),
     * heterozygousByHomozygousRecessive);
     * i++;
     * parentCrossMap.put(Integer.valueOf(parentCrosses[i]),
     * bothHomozygousRecessive);
     * }
     */

    // method for user-selected phenotype from list
    public String selectPhenotype(String selectionMenu, Scanner input, List<String> phenoList) {
        System.out.println(selectionMenu);
        for (String pheno : phenoList) {
            System.out.println("- " + pheno);
        }
        phenotype = input.nextLine();
        return phenotype;
    }

    // have phenotype, need a random genotype
    public int generateGenotype(Map<Integer, String> map, String phenotype) {
        ArrayList<Integer> possibleGenotypes = getKeyByValue(map, phenotype);
        int genotype = RandomUtils.random(possibleGenotypes);
        return genotype;
    }

    // Helper method to get key by value from HashMap
    public ArrayList<Integer> getKeyByValue(Map<Integer, String> map, String value) {
        ArrayList<Integer> possibleGenotypes = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key).equalsIgnoreCase(value)) {
                possibleGenotypes.add(key);
            }
        }
        return possibleGenotypes;
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

    // method to randomize phenotype from list of options
    public String randomizePhenotype(List<String> phenoList) {
        phenotype = RandomUtils.random(phenoList);
        return phenotype;
    }

    /*
     * ------ methods to recombine traits (reproduction / randomization) ------
     */

    // choose the parent from population list
    public static Person selectParent(String type, ArrayList<? extends Person> parentList, Scanner input) {
        System.out.println("Select a " + type + " from the following list:");
        int count = parentList.size();
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + parentList.get(i).toString());
        }
        int parentIndex = input.nextInt() - 1;
        Person parent = parentList.get(parentIndex);
        System.out.println(
                "Great! You selected " + parent.getFirstName() + " " + parent.getLastName() + " as the " + type + " .");
        System.out.println("--------------------------------------------------------");
        input.nextLine();
        return parent;
    }

}
