package ru.sbt.test.refactoring.devlopers.units;

import ru.sbt.test.refactoring.devlopers.MyGameCommand;
import ru.sbt.test.refactoring.framework.direction.UnitTurn;

/**
 * @author Dilshod Tadjiev
 */
public class TowerUnit extends UnitTurn {

    private int patron;

    public TowerUnit(int x, int y, int patron) {
        super(x, y);
        this.patron = patron;
    }

    public int getPatron() {
        return patron;
    }

    @Override
    public void command(char key) {
        super.command(key);
        shot(key);
    }

    public void shot(char key) {
        if (MyGameCommand.SHOT_TOWER == key && isHasPatron()) {
            patron--;
        }
    }

    private boolean isHasPatron() {
        return patron > 0;
    }
}
