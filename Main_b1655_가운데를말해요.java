import java.io.*;
import java.util.*;

/*
* 일자 : 2021.01.20
* 메모리 : -	
* 시간 :  시간초과 (미해결)
*/


public class Main_b1655_가운데를말해요 {

	static int n, minSize, maxSize, answer;
	
	static PriorityQueue<Integer> minHeap;
	static PriorityQueue<Integer> maxHeap;
	
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);
		
		minSize = 0;
		maxSize = 0;
		
		//오름차
		minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});
		
		//내림차순
		maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		
		int temp = Integer.parseInt(br.readLine());
		answer = temp;
		int pre;
		maxHeap.offer(answer);
		System.out.println(answer);
		
		for(int i = 1;i<n;i++) {
			pre = temp;
			temp = Integer.parseInt(br.readLine());
			
			if(temp > pre) {
				minHeap.offer(temp);
			}
			else {
				maxHeap.offer(temp);
			}
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
			{
				int a = maxHeap.poll();
				int b = minHeap.poll();
				maxHeap.offer(b);
				minHeap.offer(a);
			}
			
			answer = maxHeap.peek();
			System.out.println(answer);
		}
	}
}