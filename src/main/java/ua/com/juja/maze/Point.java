package ua.com.juja.maze;

import java.awt.*;

/**
 *
 */
public class Point {
    public static final char BUSY = '*';
    public static final char FREE = '-';

    int x;
    int y;
    boolean isFree;
    Color color; // WHITE = FREE,  BLACK = BUSY, RED - ENTRY, GREEN - EXIT, YELLOW - path marker


    // Default = BUSY
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.BLACK;
    }

    public Point(int x, int y, boolean isFree) {
        this(x,y);
        this.isFree = isFree;
        color = isFree ? Color.WHITE : Color.BLACK;
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
