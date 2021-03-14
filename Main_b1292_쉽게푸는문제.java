import java.io.*;
import java.util.*;

public class Main{

	private static int n,m;
	private static int [] arr;	
	
	public static void main(String [] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[500500];
		
		int index = 0;
		for(int i = 1;i<=m;i++)
		{
			int count = 0;
			while(count < i) {
				arr[index] = i;
				index++;
				count++;
			}
		}
		
		int sum = 0;
		for(int i = n-1;i<m;i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
