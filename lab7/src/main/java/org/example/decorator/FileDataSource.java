package org.example.decorator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileDataSource implements DataSource {
    private final String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) throws Exception {
        Files.write(Paths.get(filename), data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String readData() throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        return new String(bytes, StandardCharsets.UTF_8);
    }
}

