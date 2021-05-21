import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b16968_차량번호판1 {
	private static boolean [] alpha = new boolean[26];
	private static boolean [] number = new boolean[10];
	private static char [] input;
	private static int cnt = 0;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = st.nextToken().toCharArray();
		dfs(0);
		System.out.println(cnt);
	}
	public static void dfs(int cur){
		
		if(cur == input.length) {
			cnt+=1;
			return;
		}

		if(input[cur] == 'd') {
			if(cur > 1 && input[cur-1] != 'd') Arrays.fill(number, false);
			for(int i = 0;i<10;i++) {
				if(!number[i]) {
					number[i] = true;
					dfs(cur+1);
				}
				number[i] = false;
			}
		}
		else {
			if(cur > 1 && input[cur-1] != 'c') Arrays.fill(alpha, false);
			
			for(int i = 0;i<26;i++) {
				if(!alpha[i]) {
					alpha[i] = true;
					dfs(cur+1);
				}
				alpha[i] = false;
			}
		}
	}
}
