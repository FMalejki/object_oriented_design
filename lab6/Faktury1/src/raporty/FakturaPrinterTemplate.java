package raporty;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public abstract class FakturaPrinterTemplate {

    public final void drukujFakture(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujStopke(faktura);
    }

    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FA z dnia: " + faktura.getDataSprzedazy());
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
    }

    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> it = faktura.getIteratorPozycji();
        while (it.hasNext()) {
            Pozycja p = it.next();
            System.out.println(
                    "Towar: " + p.getNazwa() +
                            " Ilosc: " + p.getIlosc() +
                            " Wartosc:" + p.getWartosc()
            );
        }
    }

    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: " + faktura.getSuma());
        System.out.println("=====================================================");
    }
}
