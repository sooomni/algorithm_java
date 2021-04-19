import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Main{

	static boolean[][] visited = new boolean[201][201];
	static boolean [] answer = new boolean[201];
	static int a,b,c;
	
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		dfs(0,0,c);
		
		for(int i = 0;i<201;i++) {
			if(answer[i]) System.out.print(i+" ");
		}
	}

	private static void dfs(int ba, int bb, int bc) {
		if(visited[ba][bb]) return;
		
		//a 물총이 비었을 때 c 물통의 값 체크
		if(ba == 0) answer[bc] = true;
		
		visited[ba][bb] = true;

		// a -> b 
		// 현재 a,b에 담긴 물의 양이 옮기려는 b보다 큰 경우 (넘침)
        if(ba+bb > b) {
        	//b를 가득채우고 남은 양 (ba+bb)-b는 a에.
            dfs((ba+bb)-b,b,bc);
        }else {
            dfs(0,ba+bb,bc);
        }
        
		// a -> c
		// 현재 a,c에 담긴 물의 양이 옮기려는 c보다 클 수는 없음(c는 전체 물의 양)
        dfs(0,bb,ba+bc);
        
        //b -> a
		// 현재 b,a에 담긴 물의 양이 옮기려는 a다 큰 경우 (넘침)
        if(ba+bb > a) {
        	//b를 가득채우고 남은 양 (ba+bb)-a는 b에.
            dfs(a,(ba+bb)-a,bc);
        }else {
            dfs((ba+bb),0,bc);
        }
        
		// b -> c
		// 현재 b,c에 담긴 물의 양이 옮기려는 c보다 클 수는 없음(c는 전체 물의 양)
        dfs(ba,0,bb+bc);
		
        // c -> a
        // 현재 c,a에 담긴 물의 양이 옮기려는 a다 큰 경우 (넘침)
        if(ba+bc > a) {
        	dfs(a,bb,(ba+bc)-a);
        }
        else {
        	dfs(ba+bc, bb, 0);
        }
        
        // c -> b
        // 현재 c,b에 담긴 물의 양이 옮기려는 b다 큰 경우 (넘침)
        if(bb+bc > b) {
        	dfs(ba,b,(bb+bc)-b);
        }
        else {
        	dfs(ba,bb+bc, 0);
        }
	}

	
} 
