import java.util.*;
import java.io.*;

public class Main_b10974_다음수열{
	private static int n;
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(next_permutation(arr)) {
			for(int i = 0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
		}else {
			System.out.println(-1);
		}

	} 
	
	private static boolean next_permutation(int [] arr) {
		
		int i = n-1;
		while(i >0 && arr[i-1] >= arr[i]) {
			i--;
		}
		if(i<=0) {
			return false;
		}
		
		int j = n-1;
		while(arr[i-1] >= arr[j]) {
			j--;
		}
		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;
		
		j = n-1;
		while(i<j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		return true;		
	}
	
}
