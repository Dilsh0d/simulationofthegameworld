package ru.sbt.test.refactoring.framework;

import ru.sbt.test.refactoring.framework.units.Unit;
import ru.sbt.test.refactoring.framework.units.UnitStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dilshod Tadjiev
 */
public class GameUnitStrategy {

    private Map<String, UnitStrategy> unitsMap = new HashMap<String, UnitStrategy>();

    public GameUnitStrategy(int mapWidth, int mapHeight) {
        GameMap.init(mapWidth, mapHeight);
    }

    public void putUnit(String unitName, UnitStrategy unit) {
        this.unitsMap.put(unitName, unit);
        if (unit.isUseCoordinate() && GameMap.getInstance().isCoordinatesEmpty(unit.getX(), unit.getY())) {
            GameMap.getInstance().setUnitCoordinates(unit.getX(), unit.getY());
        }
    }

    public void command(String unitName, char command) {
        if (this.unitsMap.containsKey(unitName))
            this.unitsMap.get(unitName).command(command);
    }

    public void command(List<String> unitsName, char command) {
        if (unitsName != null)
            unitsName.forEach(s -> {
                command(s, command);
            });
    }
}
