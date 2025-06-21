package decorator;

import javax.xml.crypto.Data;

public class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource dataSource){
        this.wrappee = dataSource;
    }

    @Override
    public void writeData(String data){
        wrappee.writeData(data);
    }

    @Override
    public String readData(){
        return wrappee.readData();
    }
}
