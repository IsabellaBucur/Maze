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
		System.out.println("Introduceti marimea labirintului:");
		int linii = scan.nextInt();
		int coloane= scan.nextInt();
		System.out.println("Introduceti coordonatele punctului de intrare:");
		int xIn=scan.nextInt();
		int yIn=scan.nextInt();
		System.out.println("Introduceti coordonatele punctului de iesire:");
		int xExit= scan.nextInt();
		int yExit= scan.nextInt();
		scan.close();
		int i;
		int j;
		
		
		for( i=0; i<linii; i++)
		{	
			for( j=0; j<coloane; j++)
			{ 
				if((xIn==i && yIn==j)||(xExit==i && yExit==j))
				maze[i][j]=new Cell(true , v);
				
				else if(i==0 || i==linii-1 ||j==coloane-1 ||j==0){
					maze[i][j]=new Cell(false , v);
				}
				else {r=b.nextBoolean();
				maze[i][j]=new Cell(r, v);
				}
				
			System.out.print((maze[i][j].toString()));
			}
				System.out.println("");
		
		}		
		
	}
}
