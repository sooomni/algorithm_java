import java.io.*;
import java.util.*;

public class Main {

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int input;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int tc = 0;tc<n;tc++) {
			input = Integer.parseInt(st.nextToken());
			if(input < min) min = input;
			if(input > max) max = input;
		}
		System.out.println(min+" "+max);
	}
}