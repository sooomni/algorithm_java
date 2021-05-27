import java.util.ArrayList;
import java.util.Scanner;

//삽질 했던 이유 중에 하나 멤버 변수 cnt 만들어 증가시키면 depth가 아니라
//그냥 증가시키게 되어 3번 예외케이스 (0번이 나머지 모두에 연결) 등이 문제가 된다.
//No 백트래킹 시간초과

public class Main_b13023_ABCDE {
	static int n,m;
	static int ans = 0;
	static ArrayList<Integer>[] map;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new ArrayList[n];
		for(int i = 0;i<n;i++) {
			map[i] = new ArrayList<>();
		}
		
		int n1, n2;
		for(int i = 0;i<m;i++) {
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			
			map[n1].add(n2);
			map[n2].add(n1);
		}
		
		for(int i = 0;i<n;i++) {
			if(ans == 1) break;
			dfs(new boolean[n],i,0);
		}
		
		System.out.println(ans);
	}

	private static void dfs(boolean [] visit, int now,int cnt) {
		if(ans == 1) return;

		if(cnt >= 5) {
			ans = 1;
			return;
		}
		
		for(int i = 0;i<map[now].size();i++) {
			int x = map[now].get(i);
			
			if(!visit[x]) {
				visit[x] = true;
				dfs(visit,x,cnt+1);
				visit[x] = false;
			}
		}
	}
}
