import java.io.*;
import java.util.*;

public class Main_b14889_스타트와링크{

	private static int n;
	private static int [][] map;
	private static int [] set;
	private static boolean [] check;
	
	private static int ans = Integer.MAX_VALUE;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		check = new boolean[n+1];
		set = new int[n/2];

		
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		
		dfs(0, 0);
		
		System.out.println(ans);

	}
	private static void dfs(int depth, int cur){
		if(depth == n/2) {
			int tmpS = 0;
			int tmpL = 0;
			boolean [] setCheck = new boolean[n+1];
			
			for(int i = 0;i<n/2;i++) {
				setCheck[set[i]] = true;
			}
				
			for(int i = 1;i<=n;i++) {
				if(setCheck[i]) {
					for(int j = 1;j<=n;j++) {
						if(i == j) continue;
						if(setCheck[j]) tmpS += map[i][j];
					}
				}
				else {
					for(int j = 1;j<=n;j++) {
						if(i == j) continue;
						if(!setCheck[j]) tmpL += map[i][j];
					}
				}
			}
			
			ans = Math.min(ans, Math.abs(tmpS - tmpL));
			return;
		}
			for(int i = cur+1;i<=n;i++) {
				if(check[i]) continue;
				set[depth] = i; 
				check[i]= true;
				dfs(depth+1, i);
				check[i] = false;
		}
	}
}