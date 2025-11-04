package emily.traits;

import java.util.Scanner;
import java.util.Set;

import emily.RandomUtils;

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

    // possible babies
    String[] bothHomozygousDominant = { "4" }; // AA x AA
    String[] homozygousDominantByHeterozygous = { "4", "3" }; // AA x Aa
    String[] homozygousDominantByHomozygousRecessive = { "3" }; // AA x aa
    String[] bothHeterozygous = { "4", "3", "3", "2" }; // Aa x Aa
    String[] heterozygousByHomozygousRecessive = { "3", "2" }; // Aa x aa
    String[] bothHomozygousRecessive = { "2" }; // aa x aa
    int[] parentCrosses = { 16, 12, 8, 9, 6, 4 };

    // map of parent crosses (product of their individual alleles) to posstible baby
    // combinations (saved as String arrays)
    private static HashMap<Integer, String[]> parentCrossMap = new HashMap<Integer, String[]>();
    {
        int i = 0;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHomozygousDominant);
        i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), homozygousDominantByHeterozygous);
        i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), homozygousDominantByHomozygousRecessive);
        i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHeterozygous);
        i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), heterozygousByHomozygousRecessive);
        i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHomozygousRecessive);
    }

    // method for user-selected phenotype from list
    public String selectPhenotype(String selectionMenu, Scanner input, List<String> phenoList) {
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

    public static int randomGenotype(int dadGeno, int momGeno) {
        int[] dadGene = getGeneValues(dadGeno, countGenes(dadGeno));
        int[] momGene = getGeneValues(momGeno, countGenes(momGeno));
        int genotype = makeGenotype(momGene, dadGene, parentCrossMap);
        return genotype;
    }

    public static String phenotypeFromGenotype(Map<Integer, String> map, int genotype) {
        return map.get(genotype);
    }
    // fix this ^^^

    // count number of genes per trait, return the number
    private static int countGenes(int parentGeno) {
        int i = 0;
        while (parentGeno != 0) {
            parentGeno = parentGeno / 10;
            i++;
        }
        // System.out.println(i);
        return i;
    }

    // take int, split int into placevalues, save ints in array
    private static int[] getGeneValues(int parentGeno, int count) {
        int num = count;
        int[] geneValues = new int[count];
        for (int j = 0; j < count; j++) {
            if (parentGeno / 10 != 0) {
                double d = num;
                int gene = (int) (parentGeno / (Math.pow(10, (d - 1))));
                geneValues[j] = gene;
                parentGeno = (int) (parentGeno - (gene * (Math.pow(10, (d - 1)))));
                num = num - 1;
            } else { // parentGeno / 10 = 0
                int gene = parentGeno % 10;
                geneValues[j] = gene;
            }
        }
        for (int k = 0; k < geneValues.length; k++) {
            // System.out.println(geneValues[k]);
        }
        return geneValues;
    }

    private static int makeGenotype(int[] momGene, int[] dadGene, HashMap<Integer, String[]> map) {
        String babyGeno = "";
        int babyGenotype = 0;
        for (int i = 0; i < momGene.length; i++) {
            int geneCross = momGene[i] * dadGene[i];
            String[] crossResults = map.get(geneCross);
            String gene = RandomUtils.random(crossResults);
            babyGeno = babyGeno + gene;
            babyGenotype = Integer.parseInt(babyGeno);
        }
        System.out.println(babyGenotype);
        return babyGenotype;
    }

}
