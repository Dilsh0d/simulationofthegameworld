package ru.sbt.test.refactoring;

/**
 * @author Dilshod Tadjiev
 */
public final class TwoDimensionalMap {

    private static TwoDimensionalMap _INSTANCE;

    private int[][] map;

    private TwoDimensionalMap(int width, int height) {
        this.map = new int[width][height];
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
