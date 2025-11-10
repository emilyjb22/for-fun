package emily.genetics;

import java.util.Map;
import emily.RandomUtils;

public class GeneticsEngine {

    // String[] crossResults = PunnettTable.CROSS_MAP.get(geneCross);

    public static int randomGenotype(int dadGeno, int momGeno) {
        int[] dadGene = getGeneValues(dadGeno, countGenes(dadGeno));
        int[] momGene = getGeneValues(momGeno, countGenes(momGeno));
        int genotype = makeGenotype(momGene, dadGene, PunnettTable.CROSS_MAP);
        return genotype;
    }

    public static String phenotypeFromGenotype(Map<Integer, String> map, int genotype) {
        return map.get(genotype);
    }

    // count number of genes per trait, return the number
    private static int countGenes(int parentGeno) {
        int i = 0;
        while (parentGeno != 0) {
            parentGeno = parentGeno / 10;
            i++;
        }
        // System.out.println(i);
        return i;
    }

    // take int, split int into placevalues, save ints in array
    private static int[] getGeneValues(int parentGeno, int count) {
        int num = count;
        int[] geneValues = new int[count];
        for (int j = 0; j < count; j++) {
            if (parentGeno / 10 != 0) {
                double d = num;
                int gene = (int) (parentGeno / (Math.pow(10, (d - 1))));
                geneValues[j] = gene;
                parentGeno = (int) (parentGeno - (gene * (Math.pow(10, (d - 1)))));
                num = num - 1;
            } else { // parentGeno / 10 = 0
                int gene = parentGeno % 10;
                geneValues[j] = gene;
            }
        }
        for (int k = 0; k < geneValues.length; k++) {
            // System.out.println(geneValues[k]);
        }
        return geneValues;
    }

    private static int makeGenotype(int[] momGene, int[] dadGene, Map<Integer, String[]> map) {
        String babyGeno = "";
        int babyGenotype = 0;
        for (int i = 0; i < momGene.length; i++) {
            int geneCross = momGene[i] * dadGene[i];
            String[] crossResults = map.get(geneCross);
            String gene = RandomUtils.random(crossResults);
            babyGeno = babyGeno + gene;
            babyGenotype = Integer.parseInt(babyGeno);
        }
        System.out.println(babyGenotype);
        return babyGenotype;
    }

}
