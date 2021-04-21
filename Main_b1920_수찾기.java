import java.io.*;
import java.util.*;


//https://code.plus/course/32
//https://www.acmicpc.net/problem/1303
public class Main_Temp {

	private static int n,m;
	private static long [] arr1;
	private static long [] arr2;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr1 = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr1[i]= Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		arr2 = new long[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++) {
			arr2[i]= Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr1);

		long max = arr1[n-1];
		for(long a2 :arr2) {
			if(a2 >max) {
				System.out.println(0);
				continue;
			}
			boolean check = false;
			for(long a1 :arr1) {
				if(a1 == a2) {
					System.out.println(1); 
					check = true; 
					break;
				} 
				else if(a1 >a2) break;
				else continue;
			}
			if(!check) {System.out.println(0);}
		}
	}
}