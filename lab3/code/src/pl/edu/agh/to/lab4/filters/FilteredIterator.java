package pl.edu.agh.to.lab4.filters;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredIterator<Suspect> implements Iterator<Suspect> {
    private final Iterator<Suspect> iterator;
    private final Predicate<Suspect> filter;

    private Suspect nextElement;
    private boolean hasNextElementPrepared = false;

    public FilteredIterator(Iterator<Suspect> iterator, Predicate<Suspect> filter) {
        this.iterator = iterator;
        this.filter = filter;
    }

    @Override
    public boolean hasNext() {
        if (hasNextElementPrepared) {
            return true;
        }

        while (iterator.hasNext()) {
            Suspect candidate = iterator.next();
            if (filter.test(candidate)) {
                nextElement = candidate;
                hasNextElementPrepared = true;
                return true;
            }
        }

        return false;
    }

    @Override
    public Suspect next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        hasNextElementPrepared = false;
        return nextElement;
    }
}
