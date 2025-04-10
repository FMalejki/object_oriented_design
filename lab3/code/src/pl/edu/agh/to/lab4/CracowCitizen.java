package pl.edu.agh.to.lab4;

public class CracowCitizen extends Person {

    private int age;

    public CracowCitizen(String firstname, String lastname, int age) {
        this.age = age;
        this.super(firstname, lastname);
    }

    public int getAge() {
        return age;
    }
}
