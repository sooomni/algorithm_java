import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_b15664_n과m_10 {
	private static int[] arr;
	private static int[] input;
	private static boolean[] check;
	private static boolean[] used;
	
	private static int n,m;
	private static BufferedWriter bw;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		input = new int[n];
		used = new boolean[10001];
		check = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		comb(0,0);
		
		bw.flush();
		bw.close();
	}
	
	private static void comb(int r, int start) throws IOException {
		if(r >= m) {
			for(int i = 0;i<m;i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;				
		}
		
		int before = -1;
		for(int i = start;i<n;i++) {
			if(!check[i]  && before != input[i]) {
					before = input[i];
					arr[r] = input[i];
					check[i] = true;
					comb(r+1,i);
					check[i] = false;
			}
			
		}

	}
}