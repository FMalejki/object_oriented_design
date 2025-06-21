package decorator;

public class FileDataSource implements DataSource {
    private String filename;
    private String data;

    public FileDataSource(String filename){
        this.filename = filename;
    }

    @Override
    public void writeData(String data){
        this.data = data;
        System.out.println("--- Zapisano dane do pliku '" + this.filename + "': " + this.data);
    }

    @Override
    public String readData(){
        System.out.println("--- Odczytano dane z pliku '" + filename + "': " + data);
        return data;
    }
}
