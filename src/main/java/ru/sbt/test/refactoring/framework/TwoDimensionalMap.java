package ru.sbt.test.refactoring.framework;

/**
 * @author Dilshod Tadjiev
 */
public final class TwoDimensionalMap {

    private static TwoDimensionalMap _INSTANCE;

    private int width;
    private int height;
    private int[][] map;

    private TwoDimensionalMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMap() {
        return map;
    }

    public TwoDimensionalMap getInstance() {
        if (_INSTANCE == null) {
            throw new AssertionError("You have to call init first");
        }
        return _INSTANCE;
    }

    public synchronized TwoDimensionalMap init(int width, int height) {
        if (_INSTANCE != null) {
            throw new AssertionError("\"You already initialized me");
        }
        _INSTANCE = new TwoDimensionalMap(width, height);
        return _INSTANCE;
    }
}
