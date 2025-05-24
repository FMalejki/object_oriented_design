package rabaty;

public class ObliczCenePoRabacieKwotowym implements IObliczCenePoRabacie {
    private final double kwotaRabatu;

    public ObliczCenePoRabacieKwotowym(double kwotaRabatu) {
        if (kwotaRabatu < 0) {
            throw new IllegalArgumentException("Kwota rabatu nie może być ujemna");
        }
        this.kwotaRabatu = kwotaRabatu;
    }

    @Override
    public double obliczCenePoRabacie(double cenaPierwotna) {
        return Math.max(0, cenaPierwotna - kwotaRabatu);
    }
}
