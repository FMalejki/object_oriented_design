package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.providers.DataProvider;
import pl.edu.agh.to.lab4.providers.Provider;
import pl.edu.agh.to.lab4.suspects.Suspect;
import pl.edu.agh.to.lab4.suspects.Prisoner;
import pl.edu.agh.to.lab4.utils.Utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    private final Collection<Suspect> suspects;

    public Finder(Provider... providers) {
        var dp = new DataProvider(providers);
        this.suspects = dp.getData();
    }

    public Finder(Collection<Suspect> citizens, Map<String, Collection<Prisoner>> prisoners) {
        var dp = new DataProvider();
        dp.addSuspects(citizens);
        dp.addSuspects(Utils.flatifyList(prisoners.values()));
        this.suspects = dp.getData();
    }

    public void displayAllSuspectsWithName(String name) {
        Filters filters = new Filters(name);
        Iterator<Suspect> results = new FilteredIterator<>(suspects.iterator(), filters.getFilters());

        while (results.hasNext()) {
            Suspect s = results.next();
            System.out.println(s.display());
        }
    }
}
