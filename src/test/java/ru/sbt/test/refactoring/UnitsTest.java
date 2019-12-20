package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.devlopers.MyGameCommand;
import ru.sbt.test.refactoring.devlopers.units.PanzerUnit;
import ru.sbt.test.refactoring.devlopers.units.TowerUnit;
import ru.sbt.test.refactoring.framework.GameCommand;
import ru.sbt.test.refactoring.framework.GameUnitStrategy;
import ru.sbt.test.refactoring.framework.direction.UnitOrientation;
import ru.sbt.test.refactoring.framework.standart.StoneUnit;
import ru.sbt.test.refactoring.framework.standart.TractorUnit;
import ru.sbt.test.refactoring.framework.standart.WindUnit;
import ru.sbt.test.refactoring.framework.units.UnitStrategy;

import java.util.Arrays;

/**
 * @author: Dilsh0d Tadjiev
 */
public class UnitsTest extends TestCase {

    private GameUnitStrategy gameStrategy;

    @Override
    protected void setUp() throws Exception {
        gameStrategy = new GameUnitStrategy(20, 20);
    }

    public void testDeveloperCreateUnits(){
        gameStrategy.putUnit("tigr", new PanzerUnit(7,10,500));
        gameStrategy.putUnit("t34", new PanzerUnit(15,16,3000));
        gameStrategy.putUnit("ussr-tower", new TowerUnit(10,10,1000));


        gameStrategy.command("tigr", GameCommand.TURN_OR_MOTION_EAST);
        gameStrategy.command("tigr", MyGameCommand.SHOT_PANZER);

        gameStrategy.command("t34", GameCommand.TURN_OR_MOTION_SOUTH);
        gameStrategy.command("t34", MyGameCommand.SHOT_PANZER);

        gameStrategy.command("ussr-tower", GameCommand.TURN_OR_MOTION_EAST);
        gameStrategy.command("ussr-tower", MyGameCommand.SHOT_TOWER);

        PanzerUnit tigrPanzer = (PanzerUnit) gameStrategy.getUnit("tigr");
        assertEquals(8, tigrPanzer.getX());
        assertEquals(10, tigrPanzer.getY());
        assertEquals(UnitOrientation.EAST, tigrPanzer.getOrientation());
        assertEquals(499, tigrPanzer.getPatron());

        PanzerUnit t34Panzer = (PanzerUnit) gameStrategy.getUnit("t34");
        assertEquals(15, t34Panzer.getX());
        assertEquals(17, t34Panzer.getY());
        assertEquals(UnitOrientation.SOUTH, t34Panzer.getOrientation());
        assertEquals(2999, t34Panzer.getPatron());

        TowerUnit ussrTower = (TowerUnit) gameStrategy.getUnit("ussr-tower");
        assertEquals(10, ussrTower.getX());
        assertEquals(10, ussrTower.getY());
        assertEquals(UnitOrientation.SOUTH, t34Panzer.getOrientation());
        assertEquals(999, ussrTower.getPatron());
    }

    public void testStandardUnits() {
        gameStrategy.putUnit("stone", new StoneUnit(9,9));
        gameStrategy.putUnit("mtz", new TractorUnit(13,15));
        gameStrategy.putUnit("wind", new WindUnit());

        gameStrategy.command("mtz", GameCommand.TURN_OR_MOTION_SOUTH);
        gameStrategy.command("mtz", GameCommand.TURN_OR_MOTION_SOUTH);
        gameStrategy.command("mtz", GameCommand.TURN_OR_MOTION_WEST);

        gameStrategy.command("wind", GameCommand.TURN_OR_MOTION_WEST);
        gameStrategy.command("wind", GameCommand.TURN_OR_MOTION_EAST);

        UnitStrategy stone = gameStrategy.getUnit("stone");
        assertEquals(9, stone.getX());
        assertEquals(9, stone.getY());
        assertEquals(UnitOrientation.NONE, stone.getOrientation());

        UnitStrategy mtzTractor = gameStrategy.getUnit("mtz");
        assertEquals(12, mtzTractor.getX());
        assertEquals(17, mtzTractor.getY());
        assertEquals(UnitOrientation.WEST, mtzTractor.getOrientation());

        UnitStrategy wind = gameStrategy.getUnit("wind");
        assertEquals(UnitOrientation.EAST, wind.getOrientation());
    }

    public void testListCommandUnits() {
        gameStrategy.putUnit("t34", new PanzerUnit(15,16,3000));
        gameStrategy.putUnit("mtz", new TractorUnit(13,15));
        gameStrategy.putUnit("tigr", new PanzerUnit(7,10,500));


        gameStrategy.command(Arrays.asList("t34","mtz","tigr"),GameCommand.TURN_OR_MOTION_SOUTH);
        gameStrategy.command(Arrays.asList("t34","mtz","tigr"),GameCommand.TURN_OR_MOTION_EAST);

        PanzerUnit t34 = (PanzerUnit) gameStrategy.getUnit("t34");
        assertEquals(16, t34.getX());
        assertEquals(17, t34.getY());
        assertEquals(UnitOrientation.EAST, t34.getOrientation());


        UnitStrategy mtzTractor = gameStrategy.getUnit("mtz");
        assertEquals(14, mtzTractor.getX());
        assertEquals(16, mtzTractor.getY());
        assertEquals(UnitOrientation.EAST, mtzTractor.getOrientation());

        PanzerUnit tigr = (PanzerUnit) gameStrategy.getUnit("tigr");
        assertEquals(8, tigr.getX());
        assertEquals(11, tigr.getY());
        assertEquals(UnitOrientation.EAST, tigr.getOrientation());
    }


}
