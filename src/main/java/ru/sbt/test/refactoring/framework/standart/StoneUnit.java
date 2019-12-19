package ru.sbt.test.refactoring.framework.standart;

import ru.sbt.test.refactoring.framework.units.Unit;

/**
 * @author Dilshod Tadjiev
 */
public class StoneUnit extends Unit {

    public StoneUnit(int x, int y) {
        super(x, y);
    }

    public void command(char key) {
        // does not commands
    }
}
