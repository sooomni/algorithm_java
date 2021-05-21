import java.util.Scanner;
import java.util.Stack;

public class Solution_dfs_practice {
	private static int n,m,v;
	
	private static int [][] map;
	private static boolean [] visited;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		int n1, n2;
		for(int i = 1;i<=n;i++) {
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			map[n1][n2] = 1;
		}
		
		dfs(v);
	}

	private static void dfs(int now) {
		visited[now]  = true;
		System.out.println(now);
		
		for(int i = 1;i<=n;i++) {
			if(!visited[i] && map[now][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void dfs_stack(int now) { 
		Stack<Integer> stack = new Stack<>(); 
		stack.push(now); 
		
		boolean flag; 
		visited[now] = true; 
		System.out.print(now + " "); 
		
		while (!stack.isEmpty()){ 
			int peek = stack.peek(); 
			flag = false; 
			
			for (int i=1; i<=n; i++){ 
				if(map[peek][i] == 1 && !visited[i]) { 
					stack.push(i); 
					visited[i] = true; 
					System.out.print(i + " "); 
					flag = true; 
					break; 
					} 
				} 
				// 반복문에서 조건에 충족하지 않았을 경우 해당 정점 제거 
				if (!flag) stack.pop();
		}
	}

}
