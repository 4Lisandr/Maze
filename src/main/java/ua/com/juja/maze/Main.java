package ua.com.juja.maze;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Invalid arguments!");
            System.out.println("Usage: -path1 -path2 (for example: C://input.txt C://out.txt)");
        }

        MazeIO mazeIO = new MazeIO(args[0], args[1]);
        Maze maze = new Maze(mazeIO);



    }
}
