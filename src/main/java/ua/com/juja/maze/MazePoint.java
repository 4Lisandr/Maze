package ua.com.juja.maze;
import java.awt.*;

public class MazePoint extends Point {

    MazePoint[] adjacent = new MazePoint[4]; // храним ссылки на смежные свободные ячейки (до 4х)
    // 0 - Left  1 Up  2 Right 3 Down
    public MazePoint(int x, int y) {
        super(x, y);
        isFree = true;
        color = Color.WHITE;
    }

    public void setAdjacent() {
        if (x-2>0)
            adjacent[0] = new MazePoint(x-2, y);
    }

    public void setColor(Color color) {
        this.color = color;
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