package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataProvider implements Provider {
    private final List<Provider> sources = new ArrayList<>();
    private final List<Suspect> suspects = new ArrayList<>();

    public DataProvider(Provider... providers) {
        sources.addAll(Arrays.asList(providers));
    }

    public void addProvider(Provider provider) {
        sources.add(provider);
    }

    public void addSuspects(Collection<Suspect> suspects) {
        this.suspects.addAll(suspects);
    }

    @Override
    public Collection<Suspect> getData() {
        Collection<Suspect> all = new ArrayList<>(suspects);
        for (Provider provider : sources) {
            all.addAll(provider.getData());
        }
        return all;
    }
}
