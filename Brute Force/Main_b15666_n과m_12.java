import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_b15666_n과m_12 {
	private static int[] arr;
	private static int[] input;
	private static boolean[] check;
	
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
		check = new boolean[n]; // 같은 수 중복에 대한 체크 -> 이번 문제에서는 사용 안함  
		
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
		
		//같은 수가 input에 있어 중복 수열 방지 역할 (ex. 1 9와 1 9)
		int before = -1;
		//고른 수는 비내림차순 (ex. 1 7은 가능하나 7 1 불가)
		for(int i = start;i<n;i++) {
			if(before != input[i]) {
					before = input[i];
					arr[r] = input[i];
					comb(r+1,i);
			}
			
		}

	}
}