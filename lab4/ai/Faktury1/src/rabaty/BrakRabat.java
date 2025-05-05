package rabaty;

// Brak rabatu
public class BrakRabat implements Rabat {
    @Override
    public double oblicz(double suma) {
        return suma;
    }
}