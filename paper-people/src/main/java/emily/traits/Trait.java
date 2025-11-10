package emily.traits;

import emily.RandomUtils;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public abstract class Trait {

    protected int geneotype;
    protected String phenotype;

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

}
