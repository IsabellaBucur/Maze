package AlgoritmMaze;
import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		boolean r;
		byte v=0;
		Random b=new Random();
		Cell[][] maze =new Cell[30][30];
		Scanner scan = new Scanner(System.in);
		int linii = scan.nextInt();
		int coloane= scan.nextInt();
		scan.close();
		for(int i=0; i<=linii; i++)
		{	for(int j=0; j<=coloane; j++)
			{ r=b.nextBoolean();
				maze[i][j]=new Cell(r, v);
			System.out.print((maze[i][j].toString()));}
		System.out.println("");
		}		
	}
}
