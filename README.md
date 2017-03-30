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
    //cell's existing exists north-N  south-S  east-E  west-W
    //a cell can have more than just 1 exit, therefore we need to check all exit posibilities
    private bool N;
    private bool S;
    private bool E;
    private bool W;
    
 



    public Cell() {
        this.role = false; //it's a wall
        this.noOrVisits=0;
	//implicitly cell has no exits until added
	this.N=false;
	this.S=false;
	this.E=false;
	this.W=false;
    }
    
  //adds 1 exit to the cell
  public void addExit(Cell[][] theMaze){
	System.out.println("Type exit's cardinal point(S/N/E/W)");
	Scanner s=new Scanner(System.in);
	char cardinal=s.next().charAt(0);
	switch(cardinal):{
		case 'N':{
		this.N=true;
		break;
		}
		case 'S':{
		this.S=true;
		break;
		}
		case 'E':{
		this.E=true;
		break;
		}
		case 'W':{
		this.W=true;
		break;
		}
		default:{
		System.out.println("Incorrect input, try again");
		break;
		 }
        }
	System.out.println("Do you want the exit to be a dead end? TYPE true IF AFFIRMATE, false IF NEGGATIVE");
	boolean deadEnd=s.nextBoolean();
	
//if you want the cell's exit to be a dead end, neighbouring cells' exits won't be altered to allow passage between them
//otherwise for the exit you just added to the current cell, you will add a corresponding exit to its neighbour to allow passage
//eg: currentCell has West exit, i's right neighbour will have an East exit
  if(!deadEnd){	
    for(int i=0; i<(theMaze.length); i++){
       for(j=0; j<(theMaze[i].length); j++){
          if(theMaze[i][j].equals(this)){
	     if((this.W==true) && (j+1 < (theMaze[i].length))){ //you have to check that currentCell's neighbour is within matrix limits
	        theMaze[i][j+1].E=true;
		 return;
	     }
	     if((this.E==true) && (j-1 >= 0)){
	       theMaze[i][j-1].W=true;
	        return;
	     }
	     if((this.S==true) && (i+1 < (theMaze.length))){
	        theMaze[i+1][j].N=true;
		  return;
	     }
	     if((this.N==true) && (i-1>=0)){
	       theMaze[i-1][j].S=true;
	         return;
	     }
	  }
       }
     }
  }
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

