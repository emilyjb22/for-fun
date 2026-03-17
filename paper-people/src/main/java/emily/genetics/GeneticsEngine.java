package emily.genetics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import emily.utils.Randomize;

public class GeneticsEngine {

    // String[] crossResults = PunnettTable.CROSS_MAP.get(geneCross);

    public static int randomGenotype(int dadGeno, int momGeno) {
        int[] dadGene = getGeneValues(dadGeno, countGenes(dadGeno));
        int[] momGene = getGeneValues(momGeno, countGenes(momGeno));
        int genotype = makeGenotype(momGene, dadGene, PunnettTable.CROSS_MAP);
        return genotype;
    }

    public static String phenotypeFromGenotype(Map<Integer, String> map, int genotype) {
        return map.get(genotype);
    }

    // have phenotype, need a random genotype
    public static int generateGenotype(Map<Integer, String> map, String phenotype) {
        ArrayList<Integer> possibleGenotypes = getKeyByValue(map, phenotype);
        int genotype = Randomize.random(possibleGenotypes);
        return genotype;
    }

    // count number of genes per trait, return the number
    private static int countGenes(int parentGeno) {
        int i = 0;
        while (parentGeno != 0) {
            parentGeno = parentGeno / 10;
            i++;
        }
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
            } else {
                int gene = parentGeno % 10;
                geneValues[j] = gene;
            }
        }
        return geneValues;
    }

    private static int makeGenotype(int[] momGene, int[] dadGene, Map<Integer, String[]> map) {
        String babyGeno = "";
        int babyGenotype = 0;
        for (int i = 0; i < momGene.length; i++) {
            int geneCross = momGene[i] * dadGene[i];
            String[] crossResults = map.get(geneCross);
            String gene = Randomize.random(crossResults);
            babyGeno = babyGeno + gene;
            babyGenotype = Integer.parseInt(babyGeno);
        }
        // System.out.println(babyGenotype);
        return babyGenotype;
    }

    // Helper method to get key by value from HashMap
    public static ArrayList<Integer> getKeyByValue(Map<Integer, String> map, String value) {
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

}
