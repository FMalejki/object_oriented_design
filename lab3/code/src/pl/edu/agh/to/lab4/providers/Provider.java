package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.Collection;

public interface Provider {
    Collection<? extends Suspect> getData();
}
