import java.io.*;
import java.util.*;

public class Main_b15658_연산자끼워넣기2{

	private static int n;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int [] number;
	private static int [] sign;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		number = new int[n];
		sign = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<4;i++) {
			sign[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,number[0]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int idx, int total) {
		if(idx == n) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}
		
		for(int i = 0;i<4;i++) {
			if(sign[i] <= 0) continue;
			sign[i] -= 1;
			switch(i){
				case 0 :{dfs(idx+1,total + number[idx]); break;}
				case 1 :{dfs(idx+1,total - number[idx]); break;}
				case 2 :{dfs(idx+1,total * number[idx]);  break;}	
				case 3 :{dfs(idx+1,total / number[idx]); break;}
			}
			sign[i] += 1;
		}
	}
}