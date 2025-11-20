package emily.utils;

import java.util.List;
import java.util.Random;

public final class Randomize {

    private static final Random rand = new Random();

    // Private constructor to prevent instantiation
    private Randomize() {
    }

    // ---------- Random element from an array ----------
    public static <T> T random(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        return array[rand.nextInt(array.length)];
    }

    // ---------- Random element from a list ----------
    public static <T> T random(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty.");
        }
        return list.get(rand.nextInt(list.size()));
    }

    // ---------- Random int between min and max (inclusive) ----------
    // not needed, keeping for now
    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than max.");
        }
        return rand.nextInt(max - min + 1) + min;
    }

    // ---------- Random boolean with optional probability ----------
    // e.g., RandomUtils.randomBoolean(0.3) -> 30% chance true
    // not needed, keeping for now
    public static boolean randomBoolean(double probabilityTrue) {
        if (probabilityTrue < 0 || probabilityTrue > 1) {
            throw new IllegalArgumentException("Probability must be between 0 and 1.");
        }
        return rand.nextDouble() < probabilityTrue;
    }
}
