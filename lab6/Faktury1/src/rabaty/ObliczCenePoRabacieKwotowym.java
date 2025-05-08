package rabaty;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie{
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena - 20;
    }
}
