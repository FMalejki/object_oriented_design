package main;

public class Konfiguracja {
    private Konfiguracja () {}

    private static Konfiguracja instance;

    public static Konfiguracja getInstance() {
        if (instance == null) {
            instance = new Konfiguracja();
        }
        return instance;
    }

    public double getCurrentPercentageRabat() {
        return 0.8;
    }
    public double getCurrentValueRabat() {
        return 20;
    }


}
