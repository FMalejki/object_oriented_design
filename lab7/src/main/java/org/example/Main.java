package org.example;

import org.example.adapter.*;
import org.example.decorator.*;

public class Main {
    public static void main(String[] args) {
//        RoundHole hole = new RoundHole(5);
//
//        ClientInterface roundPeg = new RoundPeg(5);
//        System.out.println("round peg fits? " + hole.fits(roundPeg));
//
//        SquarePeg smallSq = new SquarePeg(5);
//        SquarePeg largeSq = new SquarePeg(10);
//
//        ClientInterface smallAdapter = new SquarePegAdapter(smallSq);
//        ClientInterface largeAdapter = new SquarePegAdapter(largeSq);
//
//        System.out.println("small square fits? " + hole.fits(smallAdapter));
//        System.out.println("large square fits? " + hole.fits(largeAdapter));

        // -------------------------------------------------------------------

        try {
            String originalData = "secret data!";

            DataSource plain = new FileDataSource("output.txt");

            // dekorator
            DataSource decorated = new EncryptionDecorator(
                    new CompressionDecorator(plain)
            );

            decorated.writeData(originalData);
            String read = decorated.readData();
            System.out.println("Odczytane dane (po dekoratorach):");
            System.out.println(read);

            // dla porównania co faktycznie jest w pliku
            System.out.println("\nSurowa zawartość pliku:");
            System.out.println(plain.readData());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}