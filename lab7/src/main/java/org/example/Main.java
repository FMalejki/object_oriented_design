package org.example;

import org.example.adapter.*;
import org.example.command.*;
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

//        try {
//            String originalData = "secret data!";
//
//            DataSource plain = new FileDataSource("output.txt");
//
//            // dekorator
//            DataSource decorated = new EncryptionDecorator(
//                    new CompressionDecorator(plain)
//            );
//
//            decorated.writeData(originalData);
//            String read = decorated.readData();
//            System.out.println("Odczytane dane (po dekoratorach):");
//            System.out.println(read);
//
//            // dla porównania co faktycznie jest w pliku
//            System.out.println("\nSurowa zawartość pliku:");
//            System.out.println(plain.readData());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Application app = new Application();
        app.createUI();

        System.out.println("\n--- KROK 1: Wykonanie operacji CUT ---");
        Command cut = new CutCommand(app, app.editor);
        app.executeCommand(cut);
        System.out.println("Stan edytora po CUT: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 2: Wykonanie operacji PASTE ---");
        Command paste = new PasteCommand(app, app.editor);
        app.executeCommand(paste);
        System.out.println("Stan edytora po PASTE: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 3: Wykonanie operacji COPY (nie trafia do historii) ---");
        Command copy = new CopyCommand(app, app.editor);
        app.executeCommand(copy);
        System.out.println("Stan edytora po COPY: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 4: Cofnięcie ostatniej modyfikującej operacji (PASTE) ---");
        app.undo();
        System.out.println("Stan edytora po UNDO: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 5: Cofnięcie kolejnej operacji (CUT) ---");
        app.undo();
        System.out.println("Stan edytora po drugim UNDO: '" + app.editor.text + "'");

        System.out.println("\n--- KROK 6: Próba kolejnego cofnięcia ---");
        app.undo();

    }
}