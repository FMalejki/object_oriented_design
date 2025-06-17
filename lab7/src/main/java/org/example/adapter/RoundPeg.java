package org.example.adapter;

public class RoundPeg implements ClientInterface {
    private final int radius;

    public RoundPeg(int radius) {
        this.radius = radius;
    }

    @Override
    public int getRadius() {
        return radius;
    }
}
