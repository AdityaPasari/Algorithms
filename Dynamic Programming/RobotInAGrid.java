import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RobotInAGrid {

	public static void main(String[] args){
		
		int row = 10;
		int col = 10;
		
		boolean[][] grid = new boolean[row][col];
		
		for(int x=0;x<grid.length;x++)
		    Arrays.fill( grid[x], true );
		
		grid[1][1] = false;
		grid[3][4] = false;
		grid[4][2] = false;
		grid[0][1] = false;
		grid[8][9] = false;
		grid[9][7] = false;
		
		System.out.println("The grid of possible locations:");
		display_grid(grid);		
		
		ArrayList<Point> path = getPath(grid);
		if(path!=null){
		//	Collections.reverse(path);
			
		System.out.println("The solution is : ");
		for (Point p : path) {
		    System.out.println("Robot is at (" + p.x + "," +  p.y + ")");
		}
		}
		else{
			System.out.println("\nThere is no path possible");
		}
	}
	
	static ArrayList<Point> getPath(boolean[][] maze){
		
		if(maze == null || maze.length == 0)
			return null;
		
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		
		if(getPath(maze,maze.length-1,maze[0].length-1,path,failedPoints))
		return path;
		
		return null;
	}
	
	static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
		if(col<0 || row <0 || !maze[row][col])
			return false;
		
		Point p = new Point(row,col);
		
		if(failedPoints.contains(p))
			return false;
		
		boolean IsAtOrigin = ((row==0) && (col==0));
		if(IsAtOrigin || getPath(maze,row,col-1,path,failedPoints) || getPath(maze,row-1,col,path,failedPoints)){
			path.add(p);
			return true;
		}
		
		failedPoints.add(p);
		return false;
	}
	
	static void display_grid(boolean[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j] == true)
				System.out.print("* ");
				else
					System.out.print("0 ");	
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Point{
	  public int x,y;
	  public int getX() { return x;}
	  public int getY() { return y;}
	  public void setX(int x) { this.x=x;}
	  public void setY(int y) { this.y=y;}

	  public Point() {}
	  public Point(int x,int y) { this.x=x; this.y=y;}
	}
