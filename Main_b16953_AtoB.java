import java.io.*;
import java.util.*;

public class Main {

	private static long n,m;
	private static int res,cnt;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());	
		
		res = -1;
		dfs(n,0);
		System.out.println(res);
	}

	
	public static void dfs(long cur, int cnt) {
		if(cur > m) return;
		
		if(cur == m) {
			res = cnt + 1;
			return;
		}
		dfs(cur*2, cnt+1);
		dfs(Long.parseLong(Long.toString(cur)+"1"),cnt+1);
	}
	
}
