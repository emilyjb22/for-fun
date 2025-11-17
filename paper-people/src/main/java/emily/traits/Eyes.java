package emily.traits;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

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

    private static final Map<Integer, String> EYE_COLOR_MAP;

    static {
        HashMap<Integer, String> eyeColorMap = new HashMap<>();
        int[] eyeColorGenotypes = { 44, 43, 42, 34, 33, 32, 24, 23, 22 };
        for (int i = 0; i < EYE_COLORS.size(); i++) {
            eyeColorMap.put((eyeColorGenotypes[i]), EYE_COLORS.get(i));
        }
        // Wrap the map to make it unmodifiable
        EYE_COLOR_MAP = Collections.unmodifiableMap(eyeColorMap);
    }

    // attributes needed outside the class
    private static String selectionMenu = """
            Next, we're going to select their eye color.

            What color eyes does your person have? Select from the list below, or enter
            \"R\" to randomize:
            ---------------------
            Eye color options:
            ---------------------
            """;

    // default constructor
    public Eyes() {
        this("amber", 33);
    }

    Eyes(String phenotype, int genotype) {
        super(genotype, phenotype);
    }

    public static Map<Integer, String> getEyeColorMap() {
        return EYE_COLOR_MAP;
    }

    @Override
    public List<String> getPhenotypes() {
        return EYE_COLORS;
    }

    @Override
    public String getSelectionMenu() {
        return selectionMenu;
    }

    @Override
    public Map<Integer, String> getMap() {
        return EYE_COLOR_MAP;
    }

}
