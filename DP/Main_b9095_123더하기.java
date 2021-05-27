import java.io.*;
import java.util.*;

/*
 * f(n), n = 4일 
 * 1 + 3 = 1 + f(3)<- [1+1+1, 1+2, 2+1, 3] = 4
 * 2 + 2 = 2 + f(2)<- [1+1,2] = 2
 * 3 + 1 = 3 + f(1)<- [1] = 1
 * 
 * */
public class Main_b9095_123더하기{

	private static int n;
	private static int [] dp;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		List <Integer> list = new LinkedList<>();
		
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			list.add(input);
			if(max < input) max = input;
		}
		dp = new int[11];
		dp[1] = 1;  
		dp[2] = 2;  
		dp[3] = 4;

		for(int i = 4;i<=max;i++) 
		{
			dp[i] = dp[i-1] +dp[i-2] +dp[i-3];
		}
		
		for(Integer i : list) {
			System.out.println(dp[i]);
		}
		
	}
}