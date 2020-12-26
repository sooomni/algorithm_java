import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 일자 : 2020.12.20
 * 메모리 :10803 kb
 * 시간 :1176 ms
*/

public class Main_b2217_로프 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0;i<input;i++)
		{
			arr.add(sc.nextInt());
		}

		Collections.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		int index = arr.size();
		int max = 0;
		int temp = 0;
		for(int i = arr.size();i > 0;i--) 
		{
			
			temp = arr.get(i-1) * i;
			if(max < temp)
				max = temp;
		}
		
		System.out.println(max); 
	}
}
