import java.io.*;
import java.util.*;
/*
 * 일자 : 2020.01.12
 * 메모리 : 51336 kb	
 * 시간 : 156 ms
*/
public class Main_b12865_평범한배낭 {

	private static int N, K;
	private static int [][] ans;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ans = new int[N+1][K+1];
		int [] W = new int[N+1];
		int [] V = new int[N+1];
		
		for(int i = 1;i<=N;i++) {

			 st = new StringTokenizer(br.readLine());
			 W[i] = Integer.parseInt(st.nextToken());
			 V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1;i<=N;i++) {

			 for(int j = 1; j<= K;j++) {
				 
				 if(W[i] > j)
				 {
					 ans[i][j] = ans[i-1][j];
				 }
				 else {
					 ans[i][j] = Math.max(ans[i-1][j], ans[i-1][j-W[i]]+V[i]);
				 }
			 }
		}
		
		System.out.println(ans[N][K]);
		
	} 
	
}
