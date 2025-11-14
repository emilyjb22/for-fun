package emily.traits;

import emily.Dashboard;
import emily.genetics.GeneticsEngine;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Trait {

    private int genotype;
    private String phenotype;

    public Trait() {
        this.genotype = 0;
        this.phenotype = "";
    }

    public static Trait createTrait(Scanner input, Trait trait, int dadGeno, int momGeno) {
        System.out.println("traitSelectMenu");
        String choice = input.nextLine();

        // option 1 select manually
        if (choice.equals("1")) {
            trait.setPhenotype(Dashboard.selectPhenotype(trait.getSelectionMenu(), input, trait.getPhenotypes()));
            trait.setGenotype(GeneticsEngine.generateGenotype(trait.getMap(), trait.getPhenotype()));

            // option 2 randomize
        } else if (choice.equals("2")) {
            int geno = GeneticsEngine.randomGenotype(dadGeno, momGeno);
            trait.setGenotype(geno);
            trait.setPhenotype(GeneticsEngine.phenotypeFromGenotype(trait.getMap(), geno));
        }
        return trait;
    }

    // getters and setters
    public int getGenotype() {
        return genotype;
    }

    public void setGenotype(int genotype) {
        this.genotype = genotype;
    }

    public String getPhenotype() {
        return phenotype;
    }

    public void setPhenotype(String phenotype) {
        this.phenotype = phenotype;
    }

    // things to ovrerride
    public String getSelectionMenu() {
        return "this is not working";
    }

    public List<String> getPhenotypes() {
        return null;
    }

    public Map<Integer, String> getMap() {
        return null;
    }

}
