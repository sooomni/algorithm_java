import java.io.IOException;
import java.util.Scanner;

public class Main_b1182_부분수열의합{
	private static int n,s;
	private static int ans;
	private static int [] arr;
	
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
	
		arr = new int[n+1];
		
		for(int idx = 0; idx<n; idx++) {
			arr[idx] = sc.nextInt();
		} 
		
		dfs(0,0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int idx, int sum) {
		if(idx == n) return;
		if(sum+arr[idx] == s) ans+=1;	
		
		dfs(idx+1, sum+arr[idx]);
		dfs(idx+1, sum);
	}
}  