import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

	private static int n,m,v;
	private static int [][] map;
	private static boolean [] visited;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		v = Integer.parseInt(str.nextToken());
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0;i<m; i++) {
			str = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(str.nextToken());
			int tmp2 = Integer.parseInt(str.nextToken());
			
			map[tmp1][tmp2] = 1;
			map[tmp2][tmp1] = 1;			
		}
		dfs(v);
		visited = new boolean[n+1];
		System.out.println();
		bfs(v);
	}
	
	public static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start+" ");

		for(int k = 1;k<=n;k++) {
			if(map[start][k] == 1 && !visited[k])
				dfs(k);
		}
	}
	public static void bfs(int start) {
		Queue <Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()){
			Integer cur = q.poll();
			System.out.print(cur+" ");
			
			for(int k = 1;k<=n;k++) {
				if(map[cur][k] == 1 && !visited[k]) {
					visited[k] = true;
					q.offer(k);	
				}
			}
		}
		
	}
	
}