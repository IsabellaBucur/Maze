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
