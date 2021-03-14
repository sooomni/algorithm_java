import java.io.*;
import java.util.*;

public class Main_b2693_n번째큰수 {

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[10];
		
		for(int tc = 0;tc<n;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<10;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			System.out.println(arr[7]);
		}
	}
}