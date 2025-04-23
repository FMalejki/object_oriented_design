package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.suspects.Person;
import pl.edu.agh.to.lab4.suspects.Prisoner;
import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.function.Predicate;

public class Filters {
    private final Predicate<Suspect> customPredicate;

    public Filters(String name) {
        this.customPredicate = s -> {
            if (s instanceof Person person) {
                return person.getAge() >= 18 && person.getFirstname().equals(name);
            } else if (s instanceof Prisoner prisoner) {
                return prisoner.couldBeSuspect() && prisoner.getFirstname().equals(name);
            }
            return false;
        };
    }

    public Predicate<Suspect> getFilters() {
        return customPredicate;
    }
}
