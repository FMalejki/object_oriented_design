package pl.edu.agh.to.lab4.suspects;

public class Person extends Suspect {

    private int age;

    public Person(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
