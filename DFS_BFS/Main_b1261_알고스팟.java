import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int x;
	int y;
	int wall;
	
	public Node(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
	
	public int compareTo(Node o) {
		return this.wall - o.wall;
	}
}

public class Main_b1261_알고스팟 {

	private static int n,m;
	private static char[][] map;
	private static int[][] dist;

	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		
		n = Integer.parseInt(tmp.split(" ")[0]);
		m = Integer.parseInt(tmp.split(" ")[1]);
		
		map = new char[m][n];
		dist = new int[m][n];
		
		for(int i = 0;i<m;i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dijkstra();
		System.out.println(dist[m-1][n-1]);
		
	}

	private static void dijkstra() {
		PriorityQueue <Node> q = new PriorityQueue<Node>();
		
		q.offer(new Node(0,0,0));
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int k = 0;k<4;k++) {
				
				int x = cur.x+dx[k];
				int y = cur.y+dy[k];
				int wall = cur.wall;
				
				if(x < 0 || y < 0 ||  x >= m || y >= n) continue;
				
				if(map[x][y] == '1') wall++;
				
				if(dist[x][y] > wall) {
					dist[x][y] = wall;
					q.offer(new Node(x,y,wall));
				}
				
			}
		}
	}
}