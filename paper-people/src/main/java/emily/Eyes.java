package emily;

import java.util.HashMap;
import java.util.Scanner;

public class Eyes {
    
    // variables for eye color
    String eyeColor;
    String[] eyeColors = {"black", "dark brown", "hazel", "brown", "amber", "green", "dark blue", "blue", "gray"};
    int eyeColorGenotype;
    int[] eyeColorGenotypes = {44,43,42,34,33,32,24,23,22};
    HashMap<String, String> eyeColorMap = new HashMap<String, String>();{
        for (int i = 0; i < 9; i++) {
        eyeColorMap.put(String.valueOf(eyeColorGenotypes[i]), eyeColors[i]);
        }
    }

    Eyes() {
        eyeColor = "purple";
        eyeColorGenotype = 0;
    }

    Eyes(String eyeColor, int eyeColorGenotype) {
        this.eyeColor = eyeColor;
        this.eyeColorGenotype = eyeColorGenotype;
    }
    
    public String selectEyeColor(Scanner input, HashMap<String,String> eyeColorMap){
        System.out.println("""
                                Next, we're going to select their eye color.
                                
                                What color eyes does your person have? Select from the list below, or enter \"R\" to randomize:
                                ---------------------
                                Eye color options:
                                ---------------------
                                """);
        // print list of eye colors for user to select from
        for (String color : eyeColors) {
            System.out.println("- " + color);
        }
        eyeColor = input.nextLine();
        return eyeColor;
    }

    public String randomizeEyeColor() {
            eyeColor = Person.randomize(eyeColors,eyeColor);
            return eyeColor;
    }

    // use phenotype (value) to locate corresponding genotype (key)
    public int getEyeColorGenotype(){
        eyeColorGenotype = getKeyByValue(eyeColorMap, eyeColor);
        return eyeColorGenotype; 
    }

    public String getEyeColor(){
        return eyeColor;
    }
    public int getEyeGenotype(){
        return eyeColorGenotype;
    }

    public String setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
        return eyeColor;
    }

    // Helper method to get key by value from HashMap
    public int getKeyByValue(HashMap<String, String> map, String value) {
        for (String key : map.keySet()) {
            if (map.get(key).equalsIgnoreCase(value)) {
                return Integer.parseInt(key);
            }
        }
        // Return -1 if not found
        return -1;
    }
}
