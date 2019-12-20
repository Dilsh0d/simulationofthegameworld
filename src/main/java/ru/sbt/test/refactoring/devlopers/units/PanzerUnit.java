package ru.sbt.test.refactoring.devlopers.units;

import ru.sbt.test.refactoring.devlopers.MyGameCommand;
import ru.sbt.test.refactoring.framework.traffic.UnitMotion;

/**
 * @author Dilshod Tadjiev
 */
public class PanzerUnit extends UnitMotion {

    private int patron;

    public PanzerUnit(int x, int y,int patron) {
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
        if (MyGameCommand.SHOT_PANZER == key && isHasPatron()) {
            patron--;
        }
    }

    private boolean isHasPatron() {
        return patron > 0;
    }
}
