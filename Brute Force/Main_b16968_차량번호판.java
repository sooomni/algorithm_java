import java.io.*;
import java.util.*;

public class Main_b16968_차량번호판{
	private static int n,m;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char [] inputArr =br.readLine().toCharArray(); 
		
		int ans = 1;
		
		for(int i = 0;i<inputArr.length;i++) {
			
			if(i == 0) {
				if(inputArr[i] == 'd') ans*=10;
				else ans*=26;
			}else {
				if(inputArr[i] == 'd') {
					if(inputArr[i-1] == 'd') ans*=9;
					else ans *= 10;
				}
				else {
					if(inputArr[i-1] == 'c') ans*=25;
					else ans*= 26;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans+"\n");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}