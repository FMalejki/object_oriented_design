package rabaty;

import java.util.Random;

// Przykład: losowy rabat 0–10%
public class LosowyRabat implements Rabat {
    private Random rnd = new Random();

    @Override
    public double oblicz(double suma) {
        double procent = rnd.nextDouble() * 0.10;
        return suma * (1 - procent);
    }
}