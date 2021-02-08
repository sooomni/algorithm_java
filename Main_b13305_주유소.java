import java.awt.Point;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int [] city;
	private static int [] bridge;
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);
		city = new int[n+1];
		bridge = new int[n+1];
		int sum = 0;

		PriorityQueue <Point> q = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x;
			}
		});
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<n;i++) {
			bridge[i]= Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<n;i++) {
			q.offer(new Point(Integer.parseInt(st.nextToken()), i));
		}
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			int min = temp.x;
			int index = temp.y;
			
			if(bridge[index] == 0) continue;
			
			for(int i = index; i<n;i++) {
				sum += bridge[i] * min;
				bridge[i] = 0;
			}
		}
		
		System.out.println(sum);
	}
}