package pl.edu.agh.dronka.shop.model;

public class Feature {
    private final DataType type;
    private final String value;

    public Feature(String value, DataType type) {
        this.type = type;
        this.value = value;
    }

    public Object getValue() {
        return switch (type) {
            case STRING -> value;
            //case ENUM -> (T) "Hello World";
            case BOOLEAN -> Boolean.TRUE;
            case INTEGER -> Integer.valueOf(value);
            default -> null;
        };
    }
}
