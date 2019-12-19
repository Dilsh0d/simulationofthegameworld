package ru.sbt.test.refactoring.framework;

/**
 * @author Dilshod Tadjiev
 */
public final class GameMap {

    private static GameMap _INSTANCE;

    private int width;
    private int height;
    private int[][] map;

    private GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width][height];
    }

    public boolean isCoordinatesEmpty(int newX, int newY) {
        if (newX >= 0 && newY >= 0 && newX < this.width && newY < this.height && this.map[newX][newX] == 0)
            return true;
        return false;
    }

    public void setUnitCoordinates(int x, int y) {
        this.map[x][y] = 1;
    }

    public void moveUnit(int x, int y, int newX, int newY) {
        this.map[x][y] = 0;
        this.map[newX][newY] = 1;
    }

    public static GameMap getInstance() {
        if (_INSTANCE == null) {
            throw new AssertionError("You have to call init first");
        }
        return _INSTANCE;
    }

    public static GameMap init(int width, int height) {
        if (_INSTANCE != null) {
            throw new AssertionError("You already initialized me");
        }
        _INSTANCE = new GameMap(width, height);
        return _INSTANCE;
    }
}
