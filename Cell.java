package AlgoritmMaze;
import java.util.*;

public class Cell {
    private boolean role;
    private byte noOrVisits;
    private boolean N;
    private boolean S;
    private boolean E;
    private boolean W;
    
 



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
	switch(cardinal){
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
	s.close();

	
	
  if(!deadEnd){	
    for(int i=0; i<(theMaze.length); i++){
       for(int j=0; j<(theMaze[i].length); j++){
          if(theMaze[i][j].equals(this)){
	     if((this.W==true) && (j+1 < (theMaze[i].length))){
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
        return " ";
        else return "*";
    }
}
