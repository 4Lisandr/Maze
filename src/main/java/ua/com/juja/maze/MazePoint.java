package ua.com.juja.maze;

/**
 * В свободной ячейке лабиринта рисуем стрелку, указывающую на следующую
 */
public class MazePoint extends Point {

    Direction [] directions;

    // Тупиковая или последняя ячейка имеет значение direction = Direction.STOP;
    public MazePoint(int x, int y, Direction direction) {
        super(x, y);
        isFree = true;
        directions = new Direction[1];
        directions[0] = direction;
    }
}
