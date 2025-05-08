package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie{

    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena * Konfiguracja.getInstance().getCurrentPercentageRabat();
    }
}
