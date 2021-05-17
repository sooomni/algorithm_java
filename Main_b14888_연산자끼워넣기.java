import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b14888_연산자끼워넣기 {
	private static int n;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int [] op = new int[10];
	private static boolean [] visited = new boolean[10];
	private static int [] numbers = new int[11];
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<4;i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0;j<cnt;j++) {
				op[idx++] = i+1;
			}
		}

		dfs(0, 1, numbers[0], 0);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int v, int idx, int num, int len) {
		int result = 0;
		if(len == n-1) {
			if(num > max) max = num;
			if(num < min) min = num;
		}
		else {
			for(int i = 0; i< n-1;i++) {
				if(!visited[i]) {
					switch(op[i]) {
						case 1 :{
							result = num +numbers[idx];
							break;
						}
						case 2 :{
							result = num - numbers[idx];
							break;
						}
						case 3 :{
							result = num * numbers[idx];
							break;
						}
						case 4 :{
							result = num / numbers[idx];
							break;
						}
					}
					visited[i] = true;
					dfs(i,idx+1,result,len+1);
				}
			}
		}
		visited[v] = false;
	}
	
}