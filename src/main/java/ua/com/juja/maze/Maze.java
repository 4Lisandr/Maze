package ua.com.juja.maze;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Maze {
    int length;
    int height;
    Point entry;
    Point exit;
    List<Point> path;
    List<Point> branches;
    char[][] mazeMatrix;

    // конструктор вызовем из мейна, передадим ему данные из файла
    public Maze(int length, int height, Point entry, Point exit) {
        this.length = length;
        this.height = height;
        this.entry = entry;
        this.exit = exit;
        initMatrix(height,length);
        path = createPath(entry, exit);
    }

    public Maze(MazeIO mazeIO) {
        this(mazeIO.getLength(), mazeIO.getHeight(), mazeIO.getEntry(), mazeIO.getExit());
    }
    // Идеи: проложить простой путь от входа к выходу по алгоритму змейки
    // сгенерировать препятствия на пути и обходить их
    private List<Point> createPath(Point entry, Point exit) {
        List<Point> result;
        result = createCanvas(entry, exit);
        return result;
    }
    // создать границы
    // меняем матрицу, возвращаем список из двух точек
    private List<Point> createCanvas(Point entry, Point exit) {
        List<Point> result = new ArrayList<>();
        putPoint(entry, result);
        putPoint(exit, result);
        return result;
    }

    private void putPoint(Point p, List<Point> result) {
        mazeMatrix[p.getY()][p.getX()] = Point.FREE;
        result.add(p);
    }

    // заполним матрицу звездочками
    private void initMatrix(int height, int length) {
        mazeMatrix = new char[height][length];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                mazeMatrix[y][x] = Point.BUSY;
            }
        }
    }

    public char[][] getMazeMatrix() {
        return mazeMatrix;
    }

}
