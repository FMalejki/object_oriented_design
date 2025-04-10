package pl.edu.agh.dronka.shop.model.provider.itemproviders;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.FoodItem;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.Provider;

public class FoodProvider implements Provider {
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        String dateInString = reader.getValue(
                dataLine, "Data przydatności do spożycia");
        return new FoodItem(name, category, price, quantity, dateInString);
    }
}
