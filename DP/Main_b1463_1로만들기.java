import java.util.Scanner;

public class Main_b1463_1로만들기 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		memo = new int[x + 1];
		memo[1] = 0;

		for (int i = 2; i <= x; i++) {
			memo[i] = memo[i-1]+1;
			
			if(i%2 == 0) {
				memo[i] = min(memo[i], memo[i/2]+1);
			}
			if(i%3 == 0) {
				memo[i] = min(memo[i], memo[i/3]+1);
			}
		}

		System.out.println(memo[x]);
	}

	private static int min(int i, int j) {
		return i > j ? j : i;
	}

}