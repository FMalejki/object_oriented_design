package rabaty;

import rabatlosowy.LosowyRabat;

public class LosowyRabatAdapter implements IObliczCenePoRabacie {

    private final LosowyRabat losowyRabat;

    public LosowyRabatAdapter() {
        this.losowyRabat = new LosowyRabat();
    }

    @Override
    public double obliczCenePoRabacie(double cenaPierwotna) {
        double procent = losowyRabat.losujRabat();      // np. 0.0–0.3
        return cenaPierwotna * (1 - procent);
    }
}
