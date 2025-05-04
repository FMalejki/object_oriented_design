package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class SearchByPriceWithTaxes implements SearchStrategy{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public SearchByPriceWithTaxes(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean filter(Order order) {
        BigDecimal price = order.getPriceWithTaxes();
        return minPrice.compareTo(price) <= 0 && price.compareTo(maxPrice) <= 0;
    }
}
