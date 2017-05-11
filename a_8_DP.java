import java.util.Arrays;

public class a_8_DP {

	public static void main(String[] args){
		int[] steps = {1,2,3};
		int total_steps = 1;
		
		int[][] T = Triple_Step(steps,total_steps);
		
		display_matrix(T);
		
		int total=36;
		int[] memo = new int[total+1];
		Arrays.fill(memo, -1);
		
		System.out.println(countWays(total,memo));
		
		
		
		//********************************************************************************************************************************************************//
		/*Tower of Hanoi Code
		 * 
		 */
		
	}
	
	
	
	
	static int[][] Triple_Step(int [] steps, int total){
		int T[][] = new int [steps.length+1][total+1];
		
		for(int i=1;i<T.length;i++){
			for(int j=0; j<T[0].length;j++){
				
				if(j==0){
					T[i][j] = 1;
				}
				else if(j<steps[i-1]){
					T[i][j] = T[i-1][j];
				}
				else{
					T[i][j] = T[i-1][j] + T[i][j-steps[i-1]];
				}
			}
		}
		return T;
	}
	
	static void display_matrix(int T[][]){
		System.out.println("\n\nThe Matrix is :");
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
	}
		
	static int countWays(int n, int[] memo){
		if(n<0)
			return 0;
		else if (n==0)
			return 1;
		else if(memo[n] !=-1)
			return memo[n];
		else{
		memo[n] =  (countWays(n-1,memo) + countWays(n-2,memo) + countWays(n-3,memo));
		return memo[n];
		}
	}
	
	
}
	


	
	
