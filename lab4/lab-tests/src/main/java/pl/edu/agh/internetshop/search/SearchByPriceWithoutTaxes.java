package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class SearchByPriceWithoutTaxes implements SearchStrategy{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public SearchByPriceWithoutTaxes(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean filter(Order order) {
        BigDecimal price = order.getPrice();
        return minPrice.compareTo(price) <= 0 && price.compareTo(maxPrice) <= 0;
    }
}
