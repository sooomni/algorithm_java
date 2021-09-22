import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int to;
	int w;
	
	public Node(int to, int w) {
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}

public class Main_b1753_최단경로 {

	private static int V,E,start;
    private static List<Node>[] list;
	private static int [] dist;
	private static final int INF = 100_000_000;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		dist = new int[V+1];

		Arrays.fill(dist, INF);

		for(int i = 1;i<V+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp_from = Integer.parseInt(st.nextToken());
			int tmp_to = Integer.parseInt(st.nextToken());
			int tmp_w = Integer.parseInt(st.nextToken());
			
			list[tmp_from].add(new Node(tmp_to,tmp_w));
		}
		
		Dijkstra(start);

		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<V+1;i++) {
			if(dist[i] == INF) sb.append("INF"+"\n");
			else sb.append(dist[i]+"\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void Dijkstra(int k) {
		PriorityQueue <Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1];
		pq.add(new Node(k,0));
		dist[k] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(check[cur.to]) continue;
			check[cur.to] = true;
			
			for(Node n : list[cur.to]) {
				if(dist[n.to] > n.w+ dist[cur.to])
					dist[n.to] = n.w+ dist[cur.to];
					pq.add(new Node(n.to,dist[n.to]));
			}
		}
	}
}