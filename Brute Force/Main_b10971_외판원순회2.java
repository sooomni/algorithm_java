import java.io.*;
import java.util.StringTokenizer;

public class Main_b10971_외판원순회2 {
	

	private static int n;
	private static int ans = Integer.MAX_VALUE;
	private static int [][] map;
	private static boolean[] visited;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i<n;i++) {
			visited[i] = true;
			tsp(i,i,0,0);
			visited[i] = false;
		}
		ans = Math.min(Math.max(ans, 0), Integer.MAX_VALUE);
		System.out.println(ans);
		
	}
	public static void tsp(int start, int prev, int depth, int sum) {
		if(depth == n-1) {
			if(map[prev][start] == 0) return;
			ans = Math.min(ans, sum + map[prev][start]);
			return;
			
		}
		for(int next = 0; next <n;next++) {
			if(!visited[next] && map[prev][next] != 0) {
				visited[next] = true;
				tsp(start, next, depth+1, sum+map[prev][next]);
				visited[next] = false;
			}
		}
	}
}