package ua.com.juja.maze;

/**
 *
 */
public class Point {
    public static final char BUSY = '*';
    public static final char FREE = '-';

    int x;
    int y;
    boolean isFree;

    // Default = BUSY
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean isFree) {
        this(x,y);
        this.isFree = isFree;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getChar() {
        return isFree ? FREE : BUSY;
    }
}
