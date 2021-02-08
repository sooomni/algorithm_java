import java.awt.Point;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static long [] city;
	private static long [] bridge;
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);
		city = new long[n];
		bridge = new long[n-1];

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n-1;i++) {
			bridge[i]= Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			city[i]= Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long min = city[0];
		for(int i = 0;i<n-1;i++) {
			if(city[i] < min)  min = city[i];
			sum += (min *  bridge[i]);
		}
		
		System.out.println(sum);
	}
}