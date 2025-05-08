package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie{
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena - Konfiguracja.getInstance().getCurrentValueRabat();
    }
}
