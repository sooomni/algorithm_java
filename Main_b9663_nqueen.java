import java.util.Scanner;

public class Main {
	private static int n;
	private static int count;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i = 1;i<=n;i++){
			int [] col = new int[n+1];
			
			col[1] = i;
			dfs(col, 1);
		}
		System.out.println(count);
	}
	
	public static void dfs(int [] col, int row) {
		if(row == n) count++;
		else {
			for(int i = 1;i<=n;i++) {
				col[row+1] = i;
				if(isPossible(col,row+1)) 
					dfs(col,row+1);
			}
		}
	}

	private static boolean isPossible(int[] col, int row) {
		for(int i = 1;i< row;i++) {
			if(col[i] == col[row]) return false;
			if(Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
		}
		return true;
	}
	
}
