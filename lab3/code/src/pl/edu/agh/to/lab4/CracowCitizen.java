package pl.edu.agh.to.lab4;

public class CracowCitizen extends Person {

    private int age;

    public CracowCitizen(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
