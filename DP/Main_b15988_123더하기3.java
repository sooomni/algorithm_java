import java.io.*;
import java.util.*;

public class Main_b15988_123더하기3{

	private static int n;
	private static int [] input;
	private static long [] dp;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		dp = new long[1000001];
		input = new int[n];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		dp[2] = 1+1;
		dp[3] = 1+2+1;

		for(int i = 0;i<n;i++) {
			int temp = input[i];
			for(int j = 4;j<=temp;j++) {
				dp[j] = (dp[j-1] +dp[j-2] +dp[j-3])%1000000009;
			}
			System.out.println(dp[temp]);
		}

	}
}