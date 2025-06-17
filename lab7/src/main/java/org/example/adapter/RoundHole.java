package org.example.adapter;

public class RoundHole {
    private final int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public boolean fits(ClientInterface peg) {
        return peg.getRadius() <= radius;
    }
}
