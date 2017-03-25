# Maze

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MyMaze {
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
  }

//Mainul

package amaze;

public class amaze {
    public static void main(String[] args){}
}

//Clasa Maze-ului

package amaze;

public class Maze {
    private final int xLenght;
    private final int yLenght;
    private Cell[][] maze;

    public Maze() {
        this.xLenght= 13;
        this.yLenght= 13;
        this.maze = new Cell[xLenght][yLenght];
    }


    public Maze(int xLenght, int yLenght) {
        this.xLenght = xLenght;
        this.yLenght = yLenght;
        this.maze = new Cell[xLenght][yLenght];
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

