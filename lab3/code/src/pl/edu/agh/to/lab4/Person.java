package pl.edu.agh.to.lab4;

public class Person {
    private final String firstname;

    private final String lastname;

    private int age;

    public Person(String firstname, String lastname, int age) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String display() {
        return firstname + " " + lastname;
    }
}
