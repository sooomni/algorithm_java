import java.io.*;
import java.util.*;
/*
 * 일자 : 2021.01.11
 * 메모리 :11904kb	
 * 시간 : 88 ms
*/
public class Main_b2437_저울 {

	private static int n;
	private static List <Integer> arr;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);
		
		str = br.readLine();
	    StringTokenizer st = new StringTokenizer(str);
		arr = new ArrayList<Integer>();
		int temp;
		
		for(int i = 0;i<n;i++)
		{
		
			temp = Integer.parseInt(st.nextToken());
			
			arr.add(temp);
		}
		
		Collections.sort(arr);
		
		if(arr.get(0) != 1)
		{
			System.out.println(1);
			return;
		}
		
		int sum = 0;
		
		for(int i :arr) {
			if(sum +1 < i)
			{
				System.out.println(sum+1);
				return;
			}
			sum+=i;
		}
		System.out.println(sum+1);
	}
	
}
