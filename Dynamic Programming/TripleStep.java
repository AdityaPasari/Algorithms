/*
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
 */

import java.util.Arrays;

public class TripleStep {
	public static void main(String[] args){
		
		int length = 10;
		int[] solution = new int[length+1];
		Arrays.fill(solution, -1);
		System.out.print("Total Number of Ways = ");
		System.out.println(TotalWays(length, solution));
	}
	
	
	static int TotalWays(int n, int[] solution){
		
		if(n<0)
			return 0;
		
		else if(n==0)
			return 1;
		
		else if(solution[n] != -1)
			return solution[n];
		
		else{
			solution[n] = (TotalWays(n-1,solution) + TotalWays(n-2,solution) + TotalWays(n-3,solution));
			return solution[n];
		}
	}
}
