package main;

import java.util.Calendar;
import dokumenty.Faktura;
import dokumenty.FakturaBuilder;
import dokumenty.Pozycja;
import magazyn.Towar;
import rabaty.LosowyRabat;

public class Ui {
    public static void main(String[] args) {
        Calendar teraz = Calendar.getInstance();

        // Tworzymy towary
        Towar t1 = new Towar(10, "buty");
        Towar t2 = new Towar(2, "skarpety");

        // Budujemy fakturę z losowym rabatem
        Faktura f = new FakturaBuilder()
                .atDate(teraz.getTime())
                .forKontrahent("Fido")
                .withRabat(new LosowyRabat())
                .build();

        // Dodajemy pozycje
        f.dodajPozycje(new Pozycja(t1, 3));
        f.dodajPozycje(new Pozycja(t2, 5));

        // Wypisujemy
        System.out.println("Suma przed rabatem: " + f.getSuma());
                System.out.println("Suma po rabacie:   " + f.getSumaPoRabacie());
    }
}
