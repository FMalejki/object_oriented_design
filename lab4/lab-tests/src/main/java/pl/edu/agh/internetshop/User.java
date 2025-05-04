package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.Address;

public class User {
    private static int FIRST_FREE_ID = 0;
    private final int userId;
    private final String emailAddress;
    private String firstname;
    private String surname;
    private Address address;

    public User(String firstname, String surname, String emailAddress) {
        this(firstname, surname, emailAddress, null);
    }

    public User(String firstname, String surname, String emailAddress, Address address) {
        if (firstname == null || surname == null || emailAddress == null)
            throw new IllegalArgumentException("Firstname, surname and emailAddress cannot be null.");

        this.userId = getFirstFreeId();
        this.emailAddress = emailAddress;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
    }

    private int getFirstFreeId() {
        int result = FIRST_FREE_ID;
        FIRST_FREE_ID += 1;
        return result;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
