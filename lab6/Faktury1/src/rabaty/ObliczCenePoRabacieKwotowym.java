package rabaty;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie{
    @Override
    public double obliczCenePoRabacie(double cena, double rabat) {
        return cena - rabat;
    }
}
