import java.util.Scanner;

/*
 * 일자 : 2021.01.03
 * 메모리 :12856 kb	
 * 시간 : 116 ms
*/

public class Main_b11727_2xn타일링2 {
	
	static int [] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		memo = new int[1001];
		
		memo[0] = 1;
		memo[1] = 1;
		               
		logic(n);
		System.out.println(memo[n]);
	}

	private static int logic(int n) {
		if(memo[n] != 0) 
			return memo[n];
		else
			return memo[n] = (2*logic(n-2)+ logic(n-1))%10007;
	}

}

