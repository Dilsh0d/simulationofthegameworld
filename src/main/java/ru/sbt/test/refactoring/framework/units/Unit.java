package ru.sbt.test.refactoring.framework.units;

/**
 * @author Dilshod Tadjiev
 */
public abstract class Unit {
    private int x;
    private int y;

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
