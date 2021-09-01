import java.io.*;
import java.util.*;


public class Main_b10819_차이를최대로 {

	private static int n;
	private static boolean [] selected;
	private static int ans = Integer.MIN_VALUE;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		selected = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		findArray(0, arr, new int[n]);
		
		System.out.println(ans);

	}

	private static void findArray(int idx, int[] arr, int[] sortedArr) {

		if(idx == n) {			
			ans = Math.max(ans,getSum(sortedArr));
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			sortedArr[idx] = arr[i];
			findArray(idx+1, arr, sortedArr);
			selected[i] = false;
			
		}
		
	}

	public static int getSum(int [] cur) {
		int sum = 0;
	
		
		for(int i = 0;i<n-1;i++) {
			sum += Math.abs(cur[i] - cur[i+1]);
		}
		return sum;
	}
	
}