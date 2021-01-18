import java.io.*;
import java.util.*;

/*
* 일자 : 2020.01.18
* 메모리 : 15404kb	
* 시간 :  80ms
*/
public class Main_b11726_2xn타일링 {

	private static int n;
	private static int [] dp = new int [1000001];
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);

		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2;i<=n;i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[n] % 10007);
		
	}
}