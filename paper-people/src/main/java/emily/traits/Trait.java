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

    protected Trait(int genotype, String phenotype) {
        this.genotype = genotype;
        this.phenotype = phenotype;
    }

    public static Trait createTrait(String pronoun, String traitType, Scanner input, Trait trait, int dadGeno,
            int momGeno) {
        System.out.println(Dashboard.traitSelectMenu(pronoun, traitType));
        String choice = input.nextLine();

        // option 1 select manually
        if (choice.equals("1")) {
            trait.setPhenotype(Dashboard.selectPhenotype(trait.getSelectionMenu(), input, trait.getPhenotypes()));
            trait.setGenotype(GeneticsEngine.generateGenotype(trait.getMap(), trait.getPhenotype()));

            // option 2 randomize
        } else if (choice.equals("2")) {
            trait = recombinate(trait, dadGeno, momGeno);
        }
        return trait;
    }

    public static Trait recombinate(Trait trait, int dadGeno, int momGeno) {
        int geno = GeneticsEngine.randomGenotype(dadGeno, momGeno);
        trait.setGenotype(geno);
        trait.setPhenotype(GeneticsEngine.phenotypeFromGenotype(trait.getMap(), geno));
        return trait;
    }

    // getters and setters
    public int getGenotype() {
        return genotype;
    }

    private void setGenotype(int genotype) {
        this.genotype = genotype;
    }

    public String getPhenotype() {
        return phenotype;
    }

    private void setPhenotype(String phenotype) {
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
