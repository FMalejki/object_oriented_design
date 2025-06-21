package decorator;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {
    
    public EncryptionDecorator(DataSource source){
        super(source);
    }

    @Override
    public void writeData(String data){
        String encryptedData = encryption(data);
        System.out.println("Szyfrowanie danych...");
        super.writeData(encryptedData);
    }

    @Override
    public String readData(){
        String resData = super.readData();
        System.out.println("Deszyfrowanie danych...");
        return decrypt(resData);
    }

    private String encryption(String data){
        byte[] res = data.getBytes();
        return Base64.getEncoder().encodeToString(res);
    }

    private String decrypt(String data){
        byte[] res = Base64.getDecoder().decode(data);
        return new String(res);
    }
}
