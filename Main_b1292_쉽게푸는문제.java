import java.io.*;
import java.util.*;

//n까지의 합 : n번째에 들어갈 수 

public class Main_b1292_쉽게푸는문제{

	private static int n,m;
	private static int [] arr;	
	
	public static void main(String [] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[1001];
		
		int index = 0;
		for(int i = 1;i<=45;i++)
		{
			int count = 0;
			while(count < i) {
				arr[index] = i;
				index++;
				count++;
				if(index > 1000) break;
			}
		}
		
		int sum = 0;
		for(int i = n-1;i<m;i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}

