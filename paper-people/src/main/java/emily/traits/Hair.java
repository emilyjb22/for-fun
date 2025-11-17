package emily.traits;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class Hair extends Trait {

    private static final List<String> HAIR_COLORS = Collections.unmodifiableList(List.of(
            "black", "black brown", "dark brown", "brown", "light brown", "auburn", "blonde", "strawberry blonde",
            "red", "white"));

    private static final Map<Integer, String> HAIR_COLOR_MAP;

    static {
        HashMap<Integer, String> hairColorMap = new HashMap<>();
        int[] blackHairGenotypes = { 444, 443, 442 };
        int[] blackBrownHairGenotypes = { 434, 433, 432 };
        int[] darkBrownHairGenotypes = { 424, 423, 422 };
        int[] brownHairGenotypes = { 344, 343, 334, 333 };
        int[] lightBrownHairGenotypes = { 342, 332, 322 };
        int[] auburnHairGenotypes = { 324, 323 };
        int[] blondeHairGenotypes = { 244, 243, 242, 232 };
        int[] strawberryBlondeHairGenotypes = { 234, 233 };
        int[] redHairGenotypes = { 224, 223 };
        int whiteHairGenotype = 222;

        arrayToHashMap(blackHairGenotypes, hairColorMap, "black");
        arrayToHashMap(blackBrownHairGenotypes, hairColorMap, "black-brown");
        arrayToHashMap(darkBrownHairGenotypes, hairColorMap, "dark brown");
        arrayToHashMap(brownHairGenotypes, hairColorMap, "brown");
        arrayToHashMap(lightBrownHairGenotypes, hairColorMap, "light brown");
        arrayToHashMap(auburnHairGenotypes, hairColorMap, "auburn");
        arrayToHashMap(blondeHairGenotypes, hairColorMap, "blonde");
        arrayToHashMap(strawberryBlondeHairGenotypes, hairColorMap, "strawberry blonde");
        arrayToHashMap(redHairGenotypes, hairColorMap, "red");
        hairColorMap.put(whiteHairGenotype, "white");

        // Wrap the map to make it unmodifiable
        HAIR_COLOR_MAP = Collections.unmodifiableMap(hairColorMap);
    }

    private static void arrayToHashMap(int[] array, Map<Integer, String> map, String trait) {
        int i = 0;
        for (int genotype : array)
            map.put(array[i++], trait);
    }

    private static String selectionMenu = """
            Now, we're going to select their hair color.

            What color hair does your person have? Select from the list below:
            ---------------------
            Hair color options:
            ---------------------
            """;

    // default constructor
    public Hair() {
        this("brown", 333);
    }

    Hair(String phenotype, int genotype) {
        super(genotype, phenotype);
    }

    // getters
    public static Map<Integer, String> getHairColorMap() {
        return HAIR_COLOR_MAP;
    }

    public static List<String> getHairColors() {
        return HAIR_COLORS;
    }

    @Override
    public String getSelectionMenu() {
        return selectionMenu;
    }

    @Override
    public List<String> getPhenotypes() {
        return HAIR_COLORS;
    }

    @Override
    public Map<Integer, String> getMap() {
        return HAIR_COLOR_MAP;
    }
}
