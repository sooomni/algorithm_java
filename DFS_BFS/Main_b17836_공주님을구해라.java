import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int n, m, t;
	private static int[][] map;
	private static int[][] visit;
	private static boolean get;

	private static Queue<Point> q = new LinkedList<>();
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		visit = new int[n+1][m+1];

		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		get = false;
		
		int answer = bfs(new Point(0,0));
		if(answer > t || answer == 0) System.out.println("Fail");
		else System.out.println(answer);
	
	}

	private static int bfs(Point first) {
		int cnt = 1;
		q.offer(first);
		visit[first.x][first.y] = cnt;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			cnt ++;
			for(int k = 0;k<4;k++) {
				int x = cur.x + dx[k];
				int y = cur.y + dy[k];
				
				if(x < 0 || y< 0 || x >= n || y >= m ) continue;
				
				if(map[x][y] != 1 && visit[x][y] == 0) {
					q.offer(new Point(x,y));
					visit[x][y] += cnt;
				}
			}
		}
		return visit[n-1][m-1];
	}
}