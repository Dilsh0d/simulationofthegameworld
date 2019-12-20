package ru.sbt.test.refactoring.framework.units;

import ru.sbt.test.refactoring.framework.direction.UnitOrientation;

/**
 * @author: Dilsh0d Tadjiev on 19.12.2019 17:26.
 * @project: Electron-Ticket
 * @version: 2.0
 */
public interface UnitStrategy {
    void command(char key);
    int getX();
    int getY();
    UnitOrientation getOrientation();
    boolean isUseCoordinate();
}
