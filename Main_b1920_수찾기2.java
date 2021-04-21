import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int [] arr1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) arr1[i]= Integer.parseInt(st.nextToken());
		Arrays.sort(arr1);
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int [] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++) arr2[i]= Integer.parseInt(st.nextToken());

		for(int i = 0;i<m;i++) System.out.println(solve(arr1,arr2[i]));

	}
	
	private static int solve(int[] arr, int target) {
		int low = 0;
		int high = arr.length -1;
		int mid = 0;
		
		while(low <= high) {
			mid = (high+low)/2;
			if(target == arr[mid]) return 1;
			else if(arr[mid] >target) high = mid-1;
			else if(arr[mid] <target) low = mid+1;
		}
		return 0;
	}


}