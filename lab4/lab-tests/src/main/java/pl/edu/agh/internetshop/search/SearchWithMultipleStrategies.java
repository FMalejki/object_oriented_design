package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

import java.util.List;

public class SearchWithMultipleStrategies implements SearchStrategy{
    private final List<SearchStrategy> searchStrategies;

    public SearchWithMultipleStrategies(List<SearchStrategy> searchStrategies) {
        this.searchStrategies = searchStrategies;
    }

    @Override
    public boolean filter(Order order) {
        for (SearchStrategy searchStrategy : this.searchStrategies)
            if (!searchStrategy.filter(order))
                return false;
        return true;
    }
}
