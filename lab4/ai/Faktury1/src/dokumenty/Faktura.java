package dokumenty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import rabaty.Rabat;

public class Faktura implements Iterable<Pozycja> {
    private Date dataSprzedazy;
    private String kontrahent;
    private List<Pozycja> pozycje;
    private double suma;
    private Rabat rabatStrategy;

    // Konstruktor pakietowy – wymusza użycie Buildera
    Faktura(Date dataSprzedazy, String kontrahent, Rabat rabatStrategy) {
        this.dataSprzedazy = dataSprzedazy;
        this.kontrahent = kontrahent;
        this.rabatStrategy = rabatStrategy;
        this.pozycje = new ArrayList<>();
        this.suma = 0;
    }

    public void dodajPozycje(Pozycja pozycja) {
        pozycje.add(pozycja);
        przeliczSume();
    }

    public double getSuma() {
        return suma;
    }

    public double getSumaPoRabacie() {
        return rabatStrategy.oblicz(suma);
    }

    public Date getDataSprzedazy() {
        return dataSprzedazy;
    }

    public String getKontrahent() {
        return kontrahent;
    }

    private void przeliczSume() {
        suma = 0;
        for (Pozycja p : pozycje) {
            suma += p.getWartosc();
        }
    }

    @Override
    public Iterator<Pozycja> iterator() {
        return Collections.unmodifiableList(pozycje).iterator();
    }
}
