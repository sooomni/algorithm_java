import java.io.*;
import java.awt.*;
import java.util.*;
public class Main {

	private static int n,m,k;
	
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static int [][] map; 
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for(int i = 0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		
		
		
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=m;j++) {
				if(map[i][j] == 1) {
					map[i][j] = 2;
					bfs(new Point(i,j));
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=m;j++) {				
				if(map[i][j] != 1 && map[i][j] > max) max = map[i][j];
			}
		}
		System.out.println(max-1);
	
	}

	private static void bfs(Point point) {
		Queue <Point>q = new LinkedList<>();
		q.offer(point);
		int cnt = 3;
		
		while(!q.isEmpty()) 
		{
			Point cur = q.poll();
			for(int j = 0;j<4;j++) {
				int xx = cur.x + dx[j];
				int yy = cur.y + dy[j];
				
				if(xx <= 0 || yy <= 0 || xx > n ||yy > m) continue;
				
				if(map[xx][yy] == 1) {
					q.offer(new Point(xx,yy));
					map[xx][yy] = cnt++;				
				}
			}
		}		
	}
}