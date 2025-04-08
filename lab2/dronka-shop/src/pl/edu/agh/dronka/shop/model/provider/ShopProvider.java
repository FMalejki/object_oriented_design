package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));

				Item item = new Item(name, category, price, quantity);
				item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);
                getLabels(category).forEach(label -> {
                    var value = reader.getValue(dataLine, label);
                    var type = parseTypes(label);
                    if (value != null && type != null) {
                        item.addFeature(label, type.parse(value));
                    } else {
                        // tutaj założyłem że opisy mają istnieć, i kulturalnie poinformuje o ich braku na konsoli
                        System.err.println("Error while parsing feature '" + label + "' of: '" + name + "'. Maybe there is no description?");
                    }
                });
				items.add(item);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

    private static Type parseTypes(String label) {
        switch (label) {
            case "Liczba stron" -> {
                return Type.INTEGER;
            }
            case "Twarda oprawa", "Dołączone video" -> {
                return Type.BOOLEAN;
            }
            case "Data przydatności do spożycia" -> {
                return Type.DATATYPE;
            }
            case "Gatunek muzyczny" -> {
                return Type.ENUM;
            }
            default -> {
                return null; // może nie najpiękniejsze, ale za to najpraktyczniejsze
            }
        }
    }

    private static List<String> getLabels(Category category) {
        switch (category) {
            case BOOKS -> {
                return List.of("Liczba stron", "Twarda oprawa");
            }
            case ELECTRONICS -> {
                return List.of("Mobilny", "Gwarancja");
            }
            case FOOD -> {
                return List.of("Data przydatności do spożycia");
            }
            case MUSIC -> {
                return List.of("Gatunek muzyczny", "Dołączone video");
            }
            case SPORT -> {
                return List.of(); // empty list
            }
            default -> {
                return List.of();   // zwracamy pustą listę, bo pomimo że wykorzystaliśmy wszystkie wartości enuma
                                    // to i tak kompilator wybrzydza i musi być default :(
            }
        }
    }
}
