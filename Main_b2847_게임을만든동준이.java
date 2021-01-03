import java.io.*;
import java.util.*;

/*
 * 일자 : 2021.01.03
 * 메모리 :11604 kb	
 * 시간 : 92 ms
*/

public class Main_b2847_게임을만든동준이 {
		
		private static int n;
		private static int [] arr;
		
		public static void main(String [] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			n = Integer.parseInt(str);
			
			arr = new int[n+1];
			int temp;
			int sum = 0;
			for(int i = 0;i<n;i++)
			{
				str = br.readLine();
				temp = Integer.parseInt(str);
				
				arr[i] = temp;
			}
			
		   int top = arr[n-1];
		   
		   for(int i = n-2;i>=0;i--) {
			   if(arr[i] >= top) {
				   while(arr[i] >= top)
				   {
					   sum++;
					   arr[i]--;
				   }
			   }
			   top = arr[i];
		   }
	
		   System.out.println(sum);
	}
	
}
