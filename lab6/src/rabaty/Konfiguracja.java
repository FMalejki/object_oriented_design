package rabaty;

import raporty.FakturaPrinterTemplate;
import raporty.StandardPrinter;

public class Konfiguracja {
    private static final Konfiguracja instance = new Konfiguracja();
    private IObliczCenePoRabacie strategiaRabatu;
    private FakturaPrinterTemplate printerType;

    private Konfiguracja() {
        this.strategiaRabatu = new LosowyRabatAdapter();
        this.printerType = new StandardPrinter();
    }

    public static Konfiguracja getInstance() {
        return instance;
    }

    public IObliczCenePoRabacie getObliczanieRabatu() {
        return strategiaRabatu;
    }

    public void setStrategiaRabatu(IObliczCenePoRabacie nowaStrategia) {
        this.strategiaRabatu = nowaStrategia;
    }

    public void setPrinterType(FakturaPrinterTemplate printerType) {
        this.printerType = printerType;
    }

    public FakturaPrinterTemplate getPrinter() {
        return printerType;
    }
}
