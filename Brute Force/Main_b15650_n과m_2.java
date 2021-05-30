import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복없이 M개, 오름차 순
//이미 뽑은 수보다 큰 수만 다음에 올 수 있음 
public class Main_b15650_n과m_2 {
	private static int[] arr;
	private static boolean[] visit;
	private static int n,m;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n+1];
		
		comb(0);
		
	}
	
	private static void comb(int r) {
		if(r >= m) {
			for(int i = 0;i<m;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;				
		}
		
		for(int i = 1;i<=n;i++) {
			if(!visit[i]) {
				if(r == 0 || arr[r-1]< i) {
					visit[i] = true;
					arr[r] = i;
					comb(r+1);
					visit[i] = false;
				}
			}
		}

	}
}