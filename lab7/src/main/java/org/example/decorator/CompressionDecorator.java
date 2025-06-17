package org.example.decorator;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) throws Exception {
        byte[] input = data.getBytes("UTF-8");

        // kompresja
        Deflater deflater = new Deflater();
        deflater.setInput(input);
        deflater.finish();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            baos.write(buffer, 0, count);
        }
        deflater.end();

        // kodowanie żeby móc to zapisać jako String
        String compressedBase64 = Base64.getEncoder().encodeToString(baos.toByteArray());
        super.writeData(compressedBase64);
    }

    @Override
    public String readData() throws Exception {
        String base64Data = super.readData();
        byte[] compressed = Base64.getDecoder().decode(base64Data);

        // dekompresja
        Inflater inflater = new Inflater();
        inflater.setInput(compressed);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            baos.write(buffer, 0, count);
        }
        inflater.end();

        return new String(baos.toByteArray(), "UTF-8");
    }
}
