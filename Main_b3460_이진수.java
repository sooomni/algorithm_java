import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String [] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<tc;t++) {
			
			int n = Integer.parseInt(br.readLine());
			ArrayList <Integer> arr = new ArrayList<>();
			
			while(n > 0) {
				arr.add(n%2);
				n = n /2;
			}
			
			for(int i = 0;i<arr.size();i++) {
				if(arr.get(i) == 1) System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}