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
    if (xLenght == 0|| yLenght==0) {
            throw new IllegalArgumentException("Dimensiunile trebuie sa fie mai mari decat 0");
        }
        this.xLenght = xLenght;
        this.yLenght = yLenght;
        this.maze = new Cell[xLenght][yLenght];
    }
    public Maze(Cell[][] maze) {
        if (maze == null) {
            throw new NullPointerException("Maze-ul nu poate fi null.");
        }
        if (maze.length == 0) {
            throw new IllegalArgumentException("Dimensiunea maze-ului trebuie sa fie mai mare decat 0");
        }

        this.maze = maze;
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

