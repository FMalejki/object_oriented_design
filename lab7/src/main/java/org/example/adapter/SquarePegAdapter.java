package org.example.adapter;

public class SquarePegAdapter implements ClientInterface {
    private final SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public int getRadius() {
        double halfDiagonal = squarePeg.getWidth() * Math.sqrt(2) / 2;
        return (int) Math.ceil(halfDiagonal);
    }
}