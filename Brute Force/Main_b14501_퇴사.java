import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_b14501_퇴사 {
	private static int N;
	private static int ans = Integer.MIN_VALUE;
	private static int [] profit;
	private static int [] time;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		time = new int[N];
		profit = new int[N];

		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
			
		}
		
		dfs(0,0);
		System.out.println(ans);
	}
	
	private static void dfs(int day, int total) {
		if(day == N) {
			ans = Math.max(ans, total);
			return;
		}
		dfs(day+1, total);
		
		if(day+time[day] <= N)
			dfs(day +time[day], total+profit[day]);
	
	}
}