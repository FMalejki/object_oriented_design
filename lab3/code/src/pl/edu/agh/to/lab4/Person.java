package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Person {
    private final String firstname;

    private final String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
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
