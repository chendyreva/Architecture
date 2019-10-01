package com.company.value.object;

public class Vector2 {

    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2 add(Vector2 that) {
        return new Vector2(this.x + that.x, this.y + that.y);
    }

    public Vector2 mul(double val) {
        return new Vector2(this.x * val, this.y * val);
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }
}

