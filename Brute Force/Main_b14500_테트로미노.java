import java.io.*;
import java.util.*;

public class Main222 {

	private static int n,m;
	private static int ans = Integer.MIN_VALUE;
	private static int [][] map;
	private static boolean [][] visited;
	
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //세로 y
		m = Integer.parseInt(st.nextToken()); //가로 x
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visited[i][j] = false;
				check(i,j);
				
			}
		}
		
		System.out.println(ans);
	}

	
	private static void dfs(int y, int x, int cnt, int sum) {
		if(cnt >= 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int k = 0;k<4;k++) {
			int kx = x+dx[k];
			int ky = y+dy[k];
			
			if(kx < 0 || ky < 0 || kx >= m || ky >= n || visited[ky][kx]) continue;
			
			visited[ky][kx] = true;
			dfs(ky,kx,cnt+1, sum+map[ky][kx]);
			visited[ky][kx] = false;
		}
	}


	private static void check(int y, int x) {
		if (y < n - 2 && x < m - 1)
            ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);

        if (y < n - 2 && x > 0)
            ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);

        if (y < n - 1 && x < m - 2)
            ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);

        if (y > 0 && x < m - 2)
            ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
    }
}