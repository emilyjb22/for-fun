package emily.utils;

import java.util.Scanner;

public class Ancillary {

    // Private constructor to prevent instantiation
    private Ancillary() {
    }

    public static void pause(Scanner input, String prompt) {
        // Check if there's a leftover newline from previous input
        if (input.hasNextLine()) {
            String leftover = input.nextLine();
            if (!leftover.isEmpty()) {
            }
        }

        // Now prompt the user properly
        System.out.println(prompt);
        input.nextLine(); // always waits for real Enter
    }

    public static String formatName(String name) {
        if (name.isEmpty())
            return name;
        name = name.trim();
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

}
