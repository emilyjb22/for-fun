package emily;

import java.util.Scanner;
import emily.people.Female;
import emily.people.Male;
import emily.people.Person;
import emily.people.PersonFactory;
import emily.utils.Ancillary;

/**
 * Hello world!
 */

public class App {

    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();

        // title menu
        System.out.println(dashboard.title);
        Scanner input = new Scanner(System.in);
        Ancillary.pause(input, "Press Enter to continue...");
        String choice = "";

        // "Adam" and "Eve" (to start population)
        System.out.println("To get started, we need at least one male person and one female person.");
        input.nextLine();

        System.out.println("First, let's start with Adam.");
        System.out.println("This is Adam Paper. He needs DNA.");
        Male adam = PersonFactory.createMan(input);
        Dashboard.savePerson(adam);

        Ancillary.pause(input, "Press Enter to continue...");

        System.out.println("Now, let's create Eve.");
        System.out.println("This is Eve Paper. She also needs DNA.");
        Female eve = PersonFactory.createWoman(input);
        Dashboard.savePerson(eve);

        Ancillary.pause(input, "Press Enter to continue...");

        // Main menu loop
        while (!choice.equals("5")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            switch (choice) {
                case "1" -> {
                    boolean isMale = Person.generateIsMale(input);

                    String messageA = "default message.";
                    if (isMale) {
                        messageA = "Your person is a male.";
                    } else {
                        messageA = "Your person is a female.";
                    }

                    System.out.println(messageA);

                    Person person = PersonFactory.createStarterPerson(
                            input,
                            Person.makeFirstName(input, isMale, new Male(), new Female()),
                            Person.makeLastName(input),
                            isMale);

                    Person.printPerson(person);
                    Ancillary.pause(input, "Press Enter to continue...");

                    Dashboard.addToPopulation(person, input);
                }

                case "2" -> {
                    System.out.println("Are you ready to have a baby?");
                    Male dad = (Male) Dashboard.selectParent("dad", dashboard.getAllMales(), input);
                    Female mom = (Female) Dashboard.selectParent("mom", dashboard.getAllFemales(), input);

                    System.out.println("Gestating baby...");
                    input.nextLine();

                    boolean isMale = Math.random() < 0.5;
                    if (isMale) {
                        System.out.println("Congratulations, it's a boy! ");
                    } else {
                        System.out.println("Congratulations, it's a girl! ");
                    }

                    Person baby = PersonFactory.createBaby(input, dad, mom,
                            Person.makeFirstName(input, isMale, dad, mom), isMale);
                    Person.printPerson(baby);

                    Dashboard.addToPopulation(baby, input);
                }

                case "3" -> {
                    // need to make this print better
                    System.out.println("Here is your current population:");

                    System.out.println("""
                            --------------------------------------------------------
                                            All Men in Population
                            --------------------------------------------------------
                                    """);

                    for (Male m : dashboard.getAllMales()) {
                        System.out.println(m.toString());
                    }

                    System.out.println("""
                            --------------------------------------------------------
                                            All Women in Population
                            --------------------------------------------------------
                                    """);

                    for (Female f : dashboard.getAllFemales()) {
                        System.out.println(f.toString());
                    }
                }
                case "4" -> {
                }
                case "5" -> {
                }

                default -> {
                    System.out.println("Invalid entry. Please enter a number between 1 and 4.");
                }
            }
        }
    }
}
