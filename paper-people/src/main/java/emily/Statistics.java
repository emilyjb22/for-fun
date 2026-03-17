package emily;

import java.util.List;

import emily.people.Person;

public class Statistics {

    public static int countDominantAlleles(List<? extends Person> population) {
        int count = 0;
        for (int i = 0; i < population.length(); i++) {
            Person person = population.get(i);
            // Example: counting a specific allele in eye genotype
            String eyeGenoStr = Integer.toString(person.getEyes().getGenotype());
            char allele = eyeGenoStr.charAt(j);
            if (allele == '3') {
                count++;
            } else if (allele == '4') {
                count += 2;
            } else if (allele == '2') {
                count += 0;
            }
        }
        return count;
    }

}
