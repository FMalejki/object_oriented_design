package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.filters.Finder;
import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonersDatabase;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder(new PersonDataProvider(), new PrisonersDatabase());
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
