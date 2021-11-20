import java.io.*;
import java.util.*;

public class Solution_lambda3 {
	private static int max = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int [] product = new int[n];
		int [] checkedproduct = new int[n];
		boolean [] checked = new boolean[n];	

		
		st = new StringTokenizer(br.readLine());
			
		for(int idx = 0;idx<n;idx++){
			product[idx] = Integer.parseInt(st.nextToken());
		}	
		
		//case1
		System.out.println("case 1 : "+CountingSum(product,n));
		//case2
		dfs(0,checked,checkedproduct,n,product);
		System.out.println("case 2 : " + max);
	}

	public static int CountingSum(int [] product,int n) {
	
		HashMap <Integer, Integer> hm = new HashMap<>();
		for(int i = 0;i<n;i++) {
			int cnt = 1;
			if(hm.containsKey(product[i]))
				cnt = hm.get(product[i])+1;
			hm.put(product[i], cnt);
		}
		
		List <Integer> dels = new ArrayList<>();

		int sum = 0;
		while (hm.size() > 0) {
			sum += hm.size() - 1;
			for (Integer key : hm.keySet()) {
				if (hm.get(key) == 1) dels.add(key);
				else hm.put(key, hm.get(key) - 1);
			}
			for (int i = 0; i < dels.size(); ++i) {
				hm.remove(dels.get(i));
			}
			dels.clear();
		}
		return sum;
	}
	
	public static void dfs(int cnt,boolean [] checked,int [] checkedproduct, int n, int [] product){
		if(cnt >= n){
			int ans = 0;
			for(int idx = 0;idx<n;idx++){
				if(idx == 0) continue;
				if(checkedproduct[idx] >checkedproduct[idx-1]) ans++;
			}	
			max = Math.max(max, ans);
			return;
		}
		
		for(int idx = 0;idx<n;idx++){
			if(checked[idx]) continue;
			checked[idx] = true;
			checkedproduct[cnt] = product[idx];
			dfs(cnt+1, checked,checkedproduct, n, product);	
			checked[idx] = false;			
		}
	}
}
