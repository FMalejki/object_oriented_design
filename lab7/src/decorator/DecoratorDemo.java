package decorator;

import javax.xml.crypto.Data;

public class DecoratorDemo {
    public static void main(String args[]){
        String inputData = "Nazwisko: Kowalski, Pensja: 10000";

        DataSource dataSource = new FileDataSource("salary.txt");
        dataSource = new CompressionDecorator(dataSource);
        dataSource = new EncryptionDecorator(dataSource);

        System.out.println("Dane do zapisu: " + inputData);
        System.out.println("Zapis danych...");

        // w sytuacji faktycznego zapisu do pliku:
        // dataSource.writeData(inputData);
        System.out.println("##########################\nOdczyt: ");
        // System.out.println("Oryginalne dane: " + dataSource.readData());

        DataSource plainSource = new FileDataSource("salary.txt");
        DataSource decoratedSource = new EncryptionDecorator(new CompressionDecorator(plainSource));

        plainSource.writeData("TmF6d2lza286S293YWxza2ksUGVuc2phOjEwMDAw");

        String readString = decoratedSource.readData();
        System.out.println("\nOryginalne dane: " + inputData);
        System.out.println("Odczytane dane (po dekompresji i deszyfracji): " + readString);
    }
}
