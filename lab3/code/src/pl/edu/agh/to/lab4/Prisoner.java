package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Person {
    
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;
    
    public Prisoner(String firstname, String lastname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstname, lastname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean couldBeSuspect() {
        return judgementYear + senteceDuration >= getCurrentYear();
    }
}
