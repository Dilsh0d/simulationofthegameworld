package ru.sbt.test.refactoring.framework.units;

import ru.sbt.test.refactoring.framework.direction.UnitOrientation;

/**
 * @author Dilshod Tadjiev
 */
public abstract class Unit implements UnitStrategy {
    private int x;
    private int y;
    private boolean useCoordinate = true;

    public Unit(){
        this.useCoordinate = false;
    }

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

    @Override
    public UnitOrientation getOrientation() {
        return UnitOrientation.NONE;
    }

    public boolean isUseCoordinate() {
        return useCoordinate;
    }
}
