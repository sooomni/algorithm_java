import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b11053_카드구매하기 {
	private static int n;
	public static void main(String [] args) throws IOException {
		BufferdReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int [] arr = new int[n+1];
		int [] dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		dp[0] = 0;
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=i;j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
			}
		}
		
		System.out.println(dp[n]);
	 }
	
}