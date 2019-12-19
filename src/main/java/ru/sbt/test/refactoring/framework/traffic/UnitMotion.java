package ru.sbt.test.refactoring.framework.traffic;

import ru.sbt.test.refactoring.framework.GameCommand;
import ru.sbt.test.refactoring.framework.GameMap;
import ru.sbt.test.refactoring.framework.direction.UnitOrientation;
import ru.sbt.test.refactoring.framework.direction.UnitTurn;

/**
 * @author Dilshod Tadjiev
 */
public class UnitMotion extends UnitTurn {

    public UnitMotion(int x, int y) {
        super(x, y);
    }

    @Override
    public void command(char key) {
        super.command(key);
        motion(key);
    }

    protected void motion(char key) {
        if (GameCommand.TURN_OR_MOTION_NORTH == key && GameMap.getInstance().isCoordinatesEmpty(getX(), getNewY())) {
            GameMap.getInstance().moveUnit(getX(), getY(), getX(), getNewY());
            this.setY(getNewY());
        } else if (GameCommand.TURN_OR_MOTION_WEST == key && GameMap.getInstance().isCoordinatesEmpty(getNewX(), getY())) {
            GameMap.getInstance().moveUnit(getX(), getY(), getNewX(), getY());
            this.setX(getNewX());
        } else if (GameCommand.TURN_OR_MOTION_SOUTH == key && GameMap.getInstance().isCoordinatesEmpty(getX(), getNewY())) {
            GameMap.getInstance().moveUnit(getX(), getY(), getX(), getNewY());
            this.setY(getNewY());
        } else if (GameCommand.TURN_OR_MOTION_EAST == key && GameMap.getInstance().isCoordinatesEmpty(getNewX(), getY())) {
            GameMap.getInstance().moveUnit(getX(), getY(), getNewX(), getY());
            this.setX(getNewX());
        }
    }

    private int getNewX() {
        if (UnitOrientation.WEST.equals(getOrientation()))
            return getX() - 1;
        else if (UnitOrientation.EAST.equals(getOrientation()))
            return getX() + 1;
        return getX();
    }

    private int getNewY() {
        if (UnitOrientation.NORTH.equals(getOrientation()))
            return getY() - 1;
        else if (UnitOrientation.SOUTH.equals(getOrientation()))
            return getY() + 1;
        return getY();
    }
}
