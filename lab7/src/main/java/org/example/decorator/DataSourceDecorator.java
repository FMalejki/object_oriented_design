package org.example.decorator;

public abstract class DataSourceDecorator implements DataSource {
    private final DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) throws Exception {
        wrappee.writeData(data);
    }

    @Override
    public String readData() throws Exception {
        return wrappee.readData();
    }
}
