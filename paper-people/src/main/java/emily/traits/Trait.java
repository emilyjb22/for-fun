package emily.traits;

import java.util.Scanner;
import java.util.Set;

import emily.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Trait {

    // need variables
    int geneotype;
    String phenotype;
    String selectionMenu;

    // need maps??

    // need constructors?

    // method for user-selected phenotype from list
    public String selectPhenotype(String selectionMenu, Scanner input, List<String> phenoList, String phenotype) {
        System.out.println(selectionMenu);
        for (String pheno : phenoList) {
            System.out.println("- " + pheno);
        }
        phenotype = input.nextLine();
        return phenotype;
    }

    // match phenotype with corresponding genotype (1 key to 1 value)
    // not sure if needed
    /*
     * public int matchGenotype(Map<Integer,String> map, String phenotype, int
     * genotype){
     * genotype = getKeyByValue(map, phenotype);
     * return genotype;
     * }
     */

    // search HashMap for all associated genotypes for user-selected hairColor, make
    // a set, then an array, for all associated genotypes,
    // then randomly select one of the genotypes from the array, parse the string
    // back to an int value, and save int as hairColorGenotype
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

    // method to randomize phenotype
    public String randomizePhenotype(List<String> phenoList) {
        phenotype = RandomUtils.random(phenoList);
        return phenotype;
    }

    // methods to recombine traits (i.e. reproduction)

}
