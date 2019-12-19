package ru.sbt.test.refactoring.framework.direction;

import ru.sbt.test.refactoring.framework.GameCommand;
import ru.sbt.test.refactoring.framework.units.Unit;

/**
 * @author Dilshod Tadjiev
 */
public class UnitTurn extends Unit {

    private UnitOrientation orientation = UnitOrientation.NORTH;

    public UnitTurn() {
        super();
    }

    public UnitTurn(int x, int y) {
        super(x, y);
    }

    public UnitOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(UnitOrientation orientation) {
        this.orientation = orientation;
    }

    public void command(char key) {
        turn(key);
    }

    protected void turn(char key) {
        switch (key){
            case GameCommand.TURN_OR_MOTION_NORTH: {
                this.orientation = UnitOrientation.NORTH;
                break;
            }
            case GameCommand.TURN_OR_MOTION_WEST: {
                this.orientation = UnitOrientation.WEST;
                break;
            }
            case GameCommand.TURN_OR_MOTION_SOUTH: {
                this.orientation = UnitOrientation.SOUTH;
                break;
            }
            case GameCommand.TURN_OR_MOTION_EAST: {
                this.orientation = UnitOrientation.EAST;
                break;
            }
        }
    }
}
