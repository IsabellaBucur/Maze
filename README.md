# Maze

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
/*public class MyMaze {
  private int dimensionX, dimensionY; // dimension of maze
  private int gridDimensionX, gridDimensionY; // dimension of output grid
  private char[][] grid; // output grid
  private Cell[][] cells; // 2d array of Cells
  private Random random = new Random(); // The random object

  // initialize with x and y the same
  public MyMaze(int aDimension) {
      // Initialize
      this(aDimension, aDimension);
  }
  // constructor
  public MyMaze(int xDimension, int yDimension) {
      dimensionX = xDimension;
      dimensionY = yDimension;
      gridDimensionX = xDimension * 4 + 1;
      gridDimensionY = yDimension * 2 + 1;
      grid = new char[gridDimensionX][gridDimensionY];
      init();
      generateMaze();
  }*/

//Mainul

package amaze;

public class amaze {
   public static void main(String[] args){
   Scanner input = new Scanner(System.in);
   
   }
}

//Clasa Maze-ului

package amaze;

final class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x; 
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Maze {

    private final int[][] maze;

    public Maze(int[][] maze) {
        if (maze == null) {
            throw new NullPointerException("The input maze cannot be null");
        }
        if (maze.length == 0) {
            throw new IllegalArgumentException("The size of maze should be greater than 0");
        }

        this.maze = maze;
    }

    public List<Coordinate> solve() {
        return getMazePath(0, 0, new Stack<Coordinate>());
    }

    private List<Coordinate> getMazePath(int row, int col, Stack<Coordinate> stack) {
        assert stack != null;

        stack.add(new Coordinate(row, col));

        if ((row == maze.length - 1) && (col == maze[0].length - 1)) {
            Coordinate[] coordinateArray = stack.toArray(new Coordinate[stack.size()]);
            return Arrays.asList(coordinateArray);
        }

        for (int j = col; j < maze[row].length; j++) {

            if ((j + 1) < maze[row].length && maze[row][j + 1] == 1) {
                return getMazePath(row, j + 1, stack);
            }

            if ((row + 1) < maze.length && maze[row + 1][col] == 1) {
                return getMazePath(row + 1, col, stack);
            }
        }

        return Collections.emptyList();
    }


    public static void main(String[] args) {
        int[][] m = {  {1, 0, 0},
                       {1, 1, 0},
                       {0, 1, 1} };

        Maze maze = new Maze(m);

        for (Coordinate coord :  maze.solve()) {
            System.out.println(coord.getX() + " : " + coord.getY());
        }
    }
}
    public Cell[][] getMaze() {
        return maze;
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }
    
    public String toString()
    {
        String s="";
        for(int j=0;j<yLenght;j++)
            for(int i=0;i<xLenght;i++)
                 s+="s ";
        return s;
    }
}

//Clasa celulei

package amaze;

public class Cell {
    private boolean role;
    private byte noOrVisits;

    public Cell() {
        this.role = false; //it's a wall
        this.noOrVisits=0;
    }

    public Cell(boolean role, byte noOrVisits) {
        this.role = role;
        this.noOrVisits = noOrVisits;
    }

    public boolean isRole() {
        return role;
    }

    public byte getNoOrVisits() {
        return noOrVisits;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public void setNoOrVisits(byte noOrVisits) {
        this.noOrVisits = noOrVisits;
    }
            
    public String toString()
    {
        if (this.role)
        return "0";
        else return "X";
    }
}
//Clasa robot
public class Robot
	{
	public int pozX;
	public int pozY;
	
	public Robot(int x, int y)
	{
		pozX=x;
		pozY=y;
	}
	
	public Robot goUp()
	{
		pozY++;
		return this;
	}
	public Robot goDown()
	{
		pozY--;
		return this;
	}
	public Robot goLeft()
	{
		pozX--;
		return this;
	}
	public Robot goRight()
	{
		pozX++;
		return this;
	}
}

