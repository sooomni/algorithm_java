import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_b16968_차량번호판1 {
	private static char [] input;
	private static int cnt = 0;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = st.nextToken().toCharArray();
		for(int i = 0;i<input.length;i++) {
			if(input[i] == 'c') {
				if(cnt == 0) cnt += 26;
				else {
					if(input[i-1] == 'c') cnt *= 25;
					else cnt *= 26;
				}
			}
			else {
				if(cnt == 0) cnt += 10;
				else {
					if(input[i-1] == 'd') cnt *= 9;
					else cnt *= 10;
				}
			}
		}
		System.out.println(cnt);
	}
}