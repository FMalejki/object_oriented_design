package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze();

        System.out.println(maze.getRoomNumbers());
    }
}



