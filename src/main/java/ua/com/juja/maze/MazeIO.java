package ua.com.juja.maze;

/**
 *
 */
public class MazeIO {
    // Тут работа с файлами - получить из них данные, возвращать по запросу в геттерах

    String pathIncoming;
    String pathOut;

    public MazeIO(String pathIncoming, String pathOut) {
        this.pathIncoming = pathIncoming;
        this.pathOut = pathOut;

    }

    public int getLength() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public Point getEntry() {
        return new Point(0, 0);
    }

    public Point getExit() {
        return new Point(0, 0);
    }
    /*  В выходном файле записывается матрица созданного лабиринта (одна строчка - одна строка матрицы по абсциссе).
        Матрица состоит из набора двух символов: “*” и “-”, где звездочка обозначает стену, а черточка свободное пространство.
    */
    public static void WriteMatrix(char[][] matrix){
        // write to file
    }
}
