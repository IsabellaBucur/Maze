package maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Maze {
	public Cell[][] theMaze;
	private int length;
	private int width;
	private Cell exit;
	private Cell entrance;
	
	public Maze(int w, int l){
		this.length=l+2;
		this.width=w+2;
		this.theMaze=new Cell[this.width][this.length];
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.length;j++){
				this.theMaze[i][j]=new Cell(i,j);
			}
		}
	}
	
	public void showMaze(){
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.length;j++){
				if(theMaze[i][j].getPass()==false)
					System.out.print('x');
				else
					System.out.print('0');
			}
			System.out.println();
		}
		
	}
		
	public void generateEntryExit()
	{
		Random rand = new Random();
		int i = rand.nextInt(this.width );//-1
		int j = rand.nextInt(this.length );//-1
		this.theMaze[i][j].setPass(true);
		this.exit=this.theMaze[i][j];	
		
		int choice =rand.nextInt(3);
		switch(choice){
		case 0:{
			j = rand.nextInt(this.length);
			this.theMaze[0][j].setPass(true);
			this.entrance=this.theMaze[0][j];
			break;
		}
		case 1:{
			j = rand.nextInt(this.length);
			this.theMaze[this.width - 1][j].setPass(true);
			this.entrance=this.theMaze[this.width - 1][j];
			break;
		}
		case 2:{
			i=rand.nextInt(this.width);
			this.theMaze[i][0].setPass(true);
			this.entrance=this.theMaze[i][0];
			break;
		}
		case 3:{
			i=rand.nextInt(this.width);
			this.theMaze[i][this.length - 1].setPass(true);
			this.entrance=this.theMaze[i][this.length -1];
			break;
		}
		
		}	
	}
	
	public void generateRandomPass()
	{
		int nr;
		if(this.length >= this.width)
			nr=this.length/ 2;
		else
			nr=this.width/ 2;
		Random rand = new Random();
		int i,j;
		for(int counter=0; counter<=nr; counter++){
			i=rand.nextInt(this.width-2)+1;
			j=rand.nextInt(this.length-2)+1;
			this.theMaze[i][j].setPass(true);
		}	
	}
	
	 public void generateConnections()
	{
		Cell exit1 = this.entrance;
		int iStart=this.entrance.getI();
		int jStart=this.entrance.getJ();
		ArrayList<Coordinate> potentialExits = new ArrayList<>();
		int count=0;
		while(count<40){
			if(iStart + 1 < width - 1){
				if(jStart!=0){
					if(theMaze[iStart+1][jStart].getPass()==false)
						potentialExits.add( new Coordinate(iStart + 1,jStart));
					else
						exit1 = theMaze[iStart+1][jStart];
					}
				else{
					if(theMaze[iStart+1][jStart + 1].getPass()==false)
						potentialExits.add( new Coordinate(iStart + 1,jStart+1));
					else
						exit1 = theMaze[iStart+1][jStart+1];
				}
			}
			
			if(iStart - 1 > 0){
				if(jStart!=0){
					if(theMaze[iStart -1][jStart].getPass()==false)
						potentialExits.add(new Coordinate(iStart - 1,jStart));
					else
						exit1 = theMaze[iStart -1][jStart];
				}
				else{
					if(theMaze[iStart -1][jStart+1].getPass()==false)
						potentialExits.add(new Coordinate(iStart - 1,jStart+1));
					else
						exit1 = theMaze[iStart -1][jStart+1];
				}
			}
			
			if(jStart + 1 < length - 1){
				if(iStart!=0){
					if(theMaze[iStart][jStart + 1].getPass()==false)
						potentialExits.add( new Coordinate(iStart,jStart + 1));
					else
						exit1 = theMaze[iStart][jStart + 1];
				}
				else{
					if(theMaze[iStart + 1][jStart + 1].getPass()==false)
						potentialExits.add( new Coordinate(iStart + 1,jStart + 1));
					else
						exit1 = theMaze[iStart + 1][jStart + 1];
				}
			}
			
			if(jStart - 1 > 0){
				if(iStart!=0){
					if(theMaze[iStart][jStart - 1].getPass()==false)
						potentialExits.add(new Coordinate(iStart,jStart - 1));
					else
						exit1 = theMaze[iStart][jStart - 1];
				}
				else{
					if(theMaze[iStart + 1][jStart - 1].getPass()==false)
						potentialExits.add(new Coordinate(iStart + 1,jStart - 1));
					else
						exit1 = theMaze[iStart + 1][jStart - 1];
				}
			}
			
			if(potentialExits.size()>1){
				Collections.shuffle(potentialExits);
				Random rand = new Random();
				Coordinate c;
				//c = potentialExits.get(rand.nextInt(potentialExits.size()));
				c=potentialExits.get(0);
				theMaze[c.getCoordI()][c.getCoordJ()].setPass(true);
				exit1 = theMaze[c.getCoordI()][c.getCoordJ()];
				iStart = exit1.getI();
				jStart = exit1.getJ();
			}
			else{
				iStart = exit1.getI();
				jStart = exit1.getJ();
			}
			count++;
			potentialExits.removeAll(potentialExits);
		}
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Cell getExit() {
		return exit;
	}
	public void setExit(Cell exit) {
		this.exit = exit;
		theMaze[exit.getI()][exit.getJ()].setPass(true);
	}
	public Cell getStart() {
		return entrance;
	}
	public void setStart(Cell start) {
		this.entrance = start;
	}
	

	
}
