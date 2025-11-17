package emily.util;

import java.util.Scanner;

public class AncillaryUtils {

    // Private constructor to prevent instantiation
    private AncillaryUtils() {
    }

    public static void pause(Scanner input) {
        // Check if there's a leftover newline from previous input
        if (input.hasNextLine()) {
            String leftover = input.nextLine();
            if (!leftover.isEmpty()) {
                // The leftover wasn't just a newline — it was actual input!
                // Keep it; we don't want to discard the user's text.
            }
        }

        // Now prompt the user properly
        System.out.println("Press Enter to continue...");
        input.nextLine(); // always waits for real Enter
    }

}
