package AlgoritmMaze;

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

