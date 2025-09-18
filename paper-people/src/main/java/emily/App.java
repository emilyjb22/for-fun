package emily;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //print title menu
        System.out.println(new Dashboard().title);

        Scanner input = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        input.nextLine();

        System.out.println(new Dashboard().menu);


        
    }
}

class Dashboard {

    String title ="""
                --------------------------------------
                        Paper People Project
                --------------------------------------
                    A game of simple inheritance
                --------------------------------------
                """;

    String menu = """
                --------------------------------------
                Menu:
                   1.  Create a New Person (Random)
                   2.  Create a New Person (Custom)
                   3.  Have a Baby
                   4.  View Your Population
                   5.  Exit
                --------------------------------------
                """;

}