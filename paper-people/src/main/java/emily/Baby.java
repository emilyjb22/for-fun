package emily;

import java.util.HashMap;

// possibly make this an enum
public class Baby {

    // possible babies
    String [] bothHomozygousDominant = {"4"}; // AA x AA
    String [] homozygousDominantByHeterozygous = {"4","3"}; // AA x Aa
    String [] homozygousDominantByHomozygousRecessive = {"3"}; // AA x aa
    String [] bothHeterozygous = {"4","3","3","2"}; // Aa x Aa
    String [] heterozygousByHomozygousRecessive = {"3","2"}; // Aa x aa
    String [] bothHomozygousRecessive = {"2"}; // aa x aa
    int [] parentCrosses = {16,12,8,9,6,4};

    // map of parent crosses (product of their individual alleles) to posstible baby combinations (saved as String arrays)
    private HashMap<Integer, String[]> parentCrossMap = new HashMap<Integer, String[]>();{
        int i = 0;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHomozygousDominant); i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), homozygousDominantByHeterozygous); i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), homozygousDominantByHomozygousRecessive); i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHeterozygous); i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), heterozygousByHomozygousRecessive); i++;
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), bothHomozygousRecessive);       
    }

    int dadEyeGenotype;
    int momEyeGenotype;
    int gene;
    String geneOne;
    String geneTwo;

    Baby(){
        dadEyeGenotype = 0;
        momEyeGenotype = 0;
    }

    Baby(int dadEyeGenotype, int momEyeGenotype){
        this.dadEyeGenotype = dadEyeGenotype;
        this.momEyeGenotype = momEyeGenotype;
    }


    // helper methods?
    // i.e. reusable-ish
    private int getFirstGene (int twoGenes){
        int gene = twoGenes / 10;
        return gene;
    }

    private int getLastGene (int twoOrThreeGenes){
        int gene = twoOrThreeGenes % 10;
        return gene;
    }

    private int getFirstofThreeGene (int threeGenes){
        int gene = threeGenes / 100;
        return gene;
    }
    private int getSecondofThreeGene (int threeGenes){
        int lastTwoGenes = threeGenes % 100;
        int gene = getFirstGene(lastTwoGenes);
        return gene;
    }   

    private int geneCross (int momGene, int dadGene){
        int geneCross = momGene * dadGene;
        return geneCross;
    }

    public int getBabyEyeColorGenotype (int momGene, int dadGene){
        int firstCross = geneCross(getFirstGene(momGene), getFirstGene(dadGene));
        String[] momCrossArray = parentCrossMap.get(firstCross);
        String firstGene = Person.randomize(momCrossArray, geneOne);
        int secondCross = geneCross(getLastGene(momGene), getLastGene(dadGene));
        String[] dadCrossArray = parentCrossMap.get(secondCross);
        String secondGene = Person.randomize(dadCrossArray, geneTwo);
        String babyGeneString = firstGene + secondGene;
        int babyEyeColorGenotype = Integer.parseInt(babyGeneString);
        System.out.println("The baby's eye color genotype is " + babyEyeColorGenotype + ".");
        return babyEyeColorGenotype;
    }

    public int getBabyHairColorGenotype (int momGene, int dadGene){
        int firstCross = geneCross(getFirstofThreeGene(momGene), getFirstofThreeGene(dadGene));
        String[] momCrossArray = parentCrossMap.get(firstCross);
        String firstGene = Person.randomize(momCrossArray, geneOne);
        int secondCross = geneCross(getSecondofThreeGene(momGene), getSecondofThreeGene(dadGene));
        String[] dadCrossArray = parentCrossMap.get(secondCross);
        String secondGene = Person.randomize(dadCrossArray, geneTwo);
        int thirdCross = geneCross(getLastGene(momGene), getLastGene(dadGene));
        String[] thirdCrossArray = parentCrossMap.get(thirdCross);
        String thirdGene = Person.randomize(thirdCrossArray, geneTwo);
        String babyGeneString = firstGene + secondGene + thirdGene;
        int babyHairColorGenotype = Integer.parseInt(babyGeneString);
        System.out.println("The baby's hair color genotype is " + babyHairColorGenotype + ".");
        return babyHairColorGenotype;
    }

    
}