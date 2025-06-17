package org.example.decorator;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) throws Exception {
        String encrypted = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
        super.writeData(encrypted);
    }

    @Override
    public String readData() throws Exception {
        byte[] decoded = Base64.getDecoder().decode(super.readData());
        return new String(decoded, "UTF-8");
    }
}
