package ua.com.juja.maze;

import java.awt.*;
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
    MazePoint [][] mazeMatrix;

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
//        putPoint(entry, result);
//        putPoint(exit, result);
        return result;
    }

//    private void putPoint(Point p, List<Point> result) {
//        mazeMatrix[p.getY()][p.getX()] = Point.FREE;
//        result.add(p);
//    }

    // заполним матрицу "решетом", то есть вкраплением белых клеток на черном фоне
    private void initMatrix(int height, int length) {
        mazeMatrix = new MazePoint[height][length];
        // простой частный случай, если вход и выход имеют нечетные индексы (odd),
        // а размер поля тоже нечетен, тогда odd=1
        int xOdd = (entry.getX()%2==1)?1:0;
        int yOdd = (entry.getY()%2==1)?1:0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                if (y%2==yOdd && x%2==xOdd && !isBound(x,y)){
                    MazePoint mazePoint = new MazePoint(x,y);
                    mazePoint.setAdjacent(length, height);
                    mazeMatrix[y][x] = mazePoint;
                } else {
                    mazeMatrix[y][x] = new MazePoint(x,y,false);
                }
            }
        }
    }
    // 3. Уберите стенку между текущей клеткой и выбранной
    // 4. Сделайте выбранную клетку текущей и отметьте ее как посещенную.
    private void removeTheWall(MazePoint current, MazePoint neighbor){
        if(current==null || neighbor==null || current.equals(neighbor))
            return;

        int x = 0, y = 0;
        if(current.getX()== neighbor.getX())
            y = (current.getY()+ neighbor.getY())/2;

        if(current.getY()== neighbor.getY())
            x = (current.getX()+ neighbor.getX())/2;

        current.setColor(Color.YELLOW);
        mazeMatrix[y][x].setColor(Color.YELLOW); // remove wall here
        neighbor.setColor(Color.GREEN);
    }

    private boolean isBound(int x, int y) {
        return x==0 || y==0 || x==length-1 || y == height-1;
    }

//    public char[][] getMazeMatrix() {
//        return mazeMatrix;
//    }

}
