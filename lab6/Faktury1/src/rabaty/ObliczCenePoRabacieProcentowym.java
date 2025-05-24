package rabaty;

public class ObliczCenePoRabacieProcentowym implements IObliczCenePoRabacie {
    private final double procentRabatu;

    public ObliczCenePoRabacieProcentowym(double procentRabatu) {
        if (procentRabatu < 0 || procentRabatu > 100) {
            throw new IllegalArgumentException("Procent rabatu musi być w przedziale [0,100]");
        }
        this.procentRabatu = procentRabatu;
    }

    @Override
    public double obliczCenePoRabacie(double cenaPierwotna) {
        return cenaPierwotna * (1 - procentRabatu / 100.0);
    }
}
