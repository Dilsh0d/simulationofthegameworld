package ru.sbt.test.refactoring.devlopers;

import ru.sbt.test.refactoring.devlopers.units.PanzerUnit;
import ru.sbt.test.refactoring.devlopers.units.TowerUnit;
import ru.sbt.test.refactoring.framework.GameCommand;
import ru.sbt.test.refactoring.framework.GameUnitStrategy;
import ru.sbt.test.refactoring.framework.standart.StoneUnit;
import ru.sbt.test.refactoring.framework.standart.TractorUnit;
import ru.sbt.test.refactoring.framework.standart.WindUnit;

/**
 * @author Dilshod Tadjiev
 */
public class GameMain {

    public static void main(String[] args) {
        GameUnitStrategy gameUnitStrategy = new GameUnitStrategy(100,100);

        gameUnitStrategy.putUnit("pantera", new PanzerUnit(2,10,1000));
        gameUnitStrategy.putUnit("tigr", new PanzerUnit(7,10,500));

        gameUnitStrategy.putUnit("t34", new PanzerUnit(41,45,3000));
        gameUnitStrategy.putUnit("ic-3", new PanzerUnit(43,45,2000));

        gameUnitStrategy.putUnit("ussr-tower", new TowerUnit(5,45,1000));
        gameUnitStrategy.putUnit("ussr-tower", new TowerUnit(25,45,1000));
        gameUnitStrategy.putUnit("ussr-tower", new TowerUnit(55,45,1000));

        gameUnitStrategy.putUnit("3reyx-tower", new TowerUnit(3,11,1000));
        gameUnitStrategy.putUnit("3reyx-tower", new TowerUnit(8,11,1000));
        gameUnitStrategy.putUnit("3reyx-tower", new TowerUnit(16,11,1000));

        gameUnitStrategy.putUnit("stone1", new StoneUnit(54,60));
        gameUnitStrategy.putUnit("stone2", new StoneUnit(74,88));

        gameUnitStrategy.putUnit("ttz", new TractorUnit(88,90));
        gameUnitStrategy.putUnit("mtz", new TractorUnit(23,34));

        gameUnitStrategy.putUnit("wind", new WindUnit());

        gameUnitStrategy.command("pantera", GameCommand.TURN_OR_MOTION_EAST);
        gameUnitStrategy.command("t34", GameCommand.TURN_OR_MOTION_WEST);
        gameUnitStrategy.command("t34", GameCommand.TURN_OR_MOTION_SOUTH);
        gameUnitStrategy.command("t34", GameCommand.TURN_OR_MOTION_WEST);
        gameUnitStrategy.command("t34", GameCommand.TURN_OR_MOTION_WEST);
    }
}
