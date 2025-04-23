package pl.edu.agh.to.lab4.suspects;

public abstract class Suspect {
    private final String firstname;
    private final String lastname;

    public Suspect(String firstname, String lastname) {
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

    public abstract int getAge();
}
