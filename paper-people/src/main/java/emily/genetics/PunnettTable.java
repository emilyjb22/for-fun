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
