package ua.com.juja.maze;
import java.awt.*;
import java.util.Random;

public class MazePoint extends Point {

    MazePoint[] adjacent = new MazePoint[4]; // храним ссылки на смежные свободные ячейки (до 4х)
    private boolean isVisited; // проходил ли курсор через эту клетку

    public MazePoint(int x, int y) {
        super(x, y);
        setColor(Color.WHITE);
    }

    public MazePoint(int x, int y, boolean b) {
        super(x, y, b);
    }

    // 0 - Left  1 Up  2 Right 3 Down
    public void setAdjacent(int maxX, int maxY) {
        if (x-2>0)
            adjacent[0] = new MazePoint(x-2, y);
        if (y-2>0)
            adjacent[1] = new MazePoint(x, y-2);
        if (x+2<maxX)
            adjacent[2] = new MazePoint(x+2, y);
        if (y+2<maxY)
            adjacent[3] = new MazePoint(x, y+2);
    }

    public boolean hasNotVisitedAdjacent(){
        for(MazePoint mp: adjacent){
            if(mp!=null && mp.getColor().equals(Color.WHITE))
                return true;
        }
        return false;
    }
    // 2. Выберите случайную клетку из соседних
    public MazePoint getRandomAdjacent(){
        MazePoint[] selection = new MazePoint[4];
        int selected = 0;
        for (int i = 0; i < 4; i++) {
            MazePoint mp = adjacent[i];
            if(mp!=null && mp.getColor().equals(Color.WHITE)){
                selection[selected] = mp;
                selected++;
            }
        }
        Random random = new Random();
        //random.nextInt(max - min + 1) + min, min = 0, max = 4
        return selection[random.nextInt(selected+1)];
    }

    // WHITE = FREE,  BLACK = BUSY, RED - ENTRY||EXIT, GREEN - CURRENT, YELLOW - path marker
    public void setColor(Color color) {
        this.color = color;
        isFree = !color.equals(Color.BLACK);
        isVisited = color.equals(Color.GREEN);
    //  isEntryOrExit = !color.equals(Color.RED);
    }

    public MazePoint[] getAdjacent() {
        return adjacent;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof MazePoint &&
                (((MazePoint) obj).getX() == x) &&
                (((MazePoint) obj).getY() == y);
    }
}
/* https://habrahabr.ru/post/262345/
Замечание: предполагается, что изначально у каждой клетки есть стенки со всех четырех сторон,
 которые отделяют ее от соседних клеток.

1. Сделайте начальную клетку текущей и отметьте ее как посещенную.
2. Пока есть непосещенные клетки
  1. Если текущая клетка имеет непосещенных «соседей»
    1. Протолкните текущую клетку в стек
    2. Выберите случайную клетку из соседних
    3. Уберите стенку между текущей клеткой и выбранной
    4. Сделайте выбранную клетку текущей и отметьте ее как посещенную.
  2. Иначе если стек не пуст
    1. Выдерните клетку из стека
    2. Сделайте ее текущей
  3. Иначе
    1. Выберите случайную непосещенную клетку, сделайте ее текущей и отметьте как посещенную.
* */