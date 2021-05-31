import java.io.*;
import java.util.*;

public class Main_b15656_n과m_7 {
	private static int [] arr;
	private static int [] ans;
	private static boolean [] visit;
	
	private static int n,m;
	private static BufferedWriter bw;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		ans = new int[m];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int r) throws IOException {
		if(r >= m) {
			for(int i = 0;i<m;i++) {
				bw.write(ans[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 0;i<n;i++) {
			ans[r] = arr[i];
			dfs(r+1);
		}
		
	}
}

