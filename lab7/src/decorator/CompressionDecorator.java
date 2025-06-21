package decorator;

public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public void writeData(String data){
        String compressedData = compression(data);
        super.writeData(compressedData);
    }

    @Override
    public String readData(){
        String res = super.readData();
        System.out.println("Decompressing data...");
        return decompression(res);
    }

    private String compression(String data){
        //usuniecie spacji
        return data.replace(" ", "");
    }

    private String decompression(String data){
        //nieodwracalna w tym przypadku ale tylko przyklad
        return data;
    }

}
