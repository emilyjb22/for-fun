package emily.people;

import emily.traits.Eyes;
import emily.traits.Hair;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String sex;
    protected Eyes eyes;
    protected Hair hair;
    protected Male dad;
    protected Female mom;

    public Person() {
        this.eyes = new Eyes();
        this.hair = new Hair();
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Male getDad() {
        return dad;
    }

    public void setDad(Male dad) {
        this.dad = dad;
    }

    public Female getMom() {
        return mom;
    }

    public void setMom(Female mom) {
        this.mom = mom;
    }

    @Override
    public String toString() {
        return "{ name: " + firstName + " " + lastName +
                ", eyes: " + eyes.getEyeColor() +
                ", hair: " + hair.getHairColor() +
                ", Dad: " + (dad != null ? dad.getFirstName() : "Unknown") +
                ", Mom: " + (mom != null ? mom.getFirstName() : "Unknown") +
                " }";
    }
}
