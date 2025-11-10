package emily.genetics;

import java.util.HashMap;
import java.util.Map;

public final class PunnettTable {

    public static final Map<Integer, String[]> CROSS_MAP = createMap();

    private static Map<Integer, String[]> createMap() {
        Map<Integer, String[]> map = new HashMap<>();

        map.put(16, new String[] { "4" }); // AA x AA
        map.put(12, new String[] { "4", "3" }); // AA x Aa
        map.put(8, new String[] { "3" }); // AA x aa
        map.put(9, new String[] { "4", "3", "3", "2" }); // Aa x Aa
        map.put(6, new String[] { "3", "2" }); // Aa x aa
        map.put(4, new String[] { "2" }); // aa x aa

        return map;
    }

    private PunnettTable() {
    } // prevent instantiation
}

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
