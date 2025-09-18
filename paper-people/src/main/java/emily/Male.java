package emily;

public class Male extends Person{

    String sex = "XY";
    String[] maleNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", 
                        "Christopher", "Daniel", "Matthew", "Anthony", "Timothy", "Mark", "Paul", "Steven", "Andrew", "Kenneth"};
    String maleName; 

    public void setMaleName(String maleName){
        this.maleName = maleName;
    }

    public String getMaleName(){
        return maleName;
    }

    public String randomName(){
        int randomIndex = (int)(Math.random() * maleNames.length);
        return maleNames[randomIndex];
    }

}



