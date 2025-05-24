package raporty;

import dokumenty.Faktura;

public class SumFirstPrinter extends FakturaPrinterTemplate {

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: " + faktura.getSuma());
    }
}
