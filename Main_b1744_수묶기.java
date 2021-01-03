import java.io.*;
import java.util.*;


//plus 는 내림차순으로 정렬해 큰 수부터 묶기
//plus에서 묶을 대상 수에 1이 있으면 곱하는 것보다 더하는 것이 전체 합에 +
//ex)1*2 = 2 , 1+2 = 3

//minus는 오름차순으로 정렬해 작은 수 부터 묶기
//0과 minus 수가 곱해지면 전체 합에 +

/*
 * 일자 : 2021.01.03
 * 메모리 :11560 kb	
 * 시간 : 84 ms
*/

public class Main_b1744_수묶기 {

	private static int n;
	private static List <Integer> arr_minus;
	private static List <Integer> arr_plus;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);
		
		arr_plus = new ArrayList<Integer>();
		arr_minus = new ArrayList<Integer>();
		int temp;
		int sum = 0;
		for(int i = 0;i<n;i++)
		{
			str = br.readLine();
			temp = Integer.parseInt(str);
			
			if(temp > 0) 
				arr_plus.add(temp);
			else if(temp <= 0)
				arr_minus.add(temp);
			}
		
	   Collections.sort(arr_plus,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}   		
	   });
	   
	   Collections.sort(arr_minus);
	   
	   for(int i = 0;i<arr_plus.size();i+=2)
	   {
		    if(i+1 >= arr_plus.size())
		    {
		    	sum += arr_plus.get(i);
		    	break;
		    }
		   	if(arr_plus.get(i) > 1 && arr_plus.get(i+1) > 1)
		   		sum += arr_plus.get(i) * arr_plus.get(i+1);
		   	else {
		   		sum += arr_plus.get(i);
		   		sum += arr_plus.get(i+1);		
		   	}
	   }
	   
	   for(int i = 0;i<arr_minus.size();i+=2)
	   {
		    if(i+1 >= arr_minus.size())
		    {
		    	sum += arr_minus.get(i);
		    	break;
		    }
		   	else {
		   		sum += arr_minus.get(i) * arr_minus.get(i+1);
		   	}
	   }
	
	   System.out.println(sum);
	   
	}
	
}
