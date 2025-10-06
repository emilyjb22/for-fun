package emily;

import java.util.HashMap;

// possibly make this an enum
public class Alleles {

    // possible babies
    String bothHomozygousDominant = "4"; // AA x AA
    String [] homozygousDominantByHeterozygous = {"4","3"}; // AA x Aa
    String homozygousDominantByHomozygousRecessive = "3"; // AA x aa
    String [] bothHeterozygous = {"4","3","3","2"}; // Aa x Aa
    String [] heterozygousByHomozygousRecessive = {"3","2"}; // Aa x aa
    String bothHomozygousRecessive = "2"; // aa x aa

    int [] parentCrosses = {16,12,8,9,6,4};


    // fix a lot of this
    // map of parent crosses (product of their individual alleles) to posstible baby combinations (saved as String arrays)
    private HashMap<Integer[], String[]> parentCrossMap = new HashMap<Integer[], String[]>();{
        for (int i = 0; i < 6; i++) {
        parentCrossMap.put(Integer.valueOf(parentCrosses[i]), eyeColors[i]);
        }
}
}