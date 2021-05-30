import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//중복없이 M개, 중복 허용 
public class Main_b15651_n과m_3 {
	private static int[] arr;
	private static int n,m;
	private static BufferedWriter bw;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		comb(0);
		
		bw.flush();
		bw.close();
	}
	
	private static void comb(int r) throws IOException {
		if(r >= m) {
			for(int i = 0;i<m;i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;				
		}
		
		for(int i = 1;i<=n;i++) {
			arr[r] = i;
			comb(r+1);
			
		}

	}
}