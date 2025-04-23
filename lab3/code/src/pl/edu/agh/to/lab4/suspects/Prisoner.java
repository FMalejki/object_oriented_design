package pl.edu.agh.to.lab4.suspects;

import pl.edu.agh.to.lab4.utils.Utils;

public class Prisoner extends Suspect {
    
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;
    
    public Prisoner(String firstname, String lastname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstname, lastname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean couldBeSuspect() {
        return judgementYear + sentenceDuration <= Utils.getCurrentYear();
    }

    @Override
    public int getAge() {
        return Utils.getCurrentYear() - Utils.getBirthYearFromPesel(pesel);
    }
}
