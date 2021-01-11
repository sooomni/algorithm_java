import java.io.*;
import java.util.*;
/*
 * 일자 : 2021.01.11
 * 메모리 : -	
 * 시간 : 시간초과 (미해결)
*/
class jewel{
    public int weight;
	public int price;
	
	public jewel() {}
	public jewel(int w, int p) {
		weight = w;
		price = p;
	}
	
}
public class Main_b1202_보석도둑 {

	
	private static int N, K;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<jewel> pq = new PriorityQueue<>(new Comparator<jewel>() {
			@Override
			public int compare(jewel o1, jewel o2) {
				return o2.price - o1.price;
			}
		});
		
		List <Integer> bag_weight = new ArrayList<>();
		
		int temp1, temp2;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			
			pq.add(new jewel(temp1, temp2));
		}
		
		for(int i = 0;i<K;i++) {
			bag_weight.add(Integer.parseInt(br.readLine()));
		}

		
		int count = 0;
		int sum = 0;
		int temp_bag_weight = bag_weight.size();
		
		while(temp_bag_weight > 0) {
			jewel temp_pq = pq.poll();
			
			for(int i = 0;i< temp_bag_weight ; i++) {
				if(bag_weight.get(i) >= temp_pq.weight)
				{	
					sum += temp_pq.price;
					bag_weight.remove(i);
					break;
				}
			}
			
			temp_bag_weight--;
	
		}
		System.out.println(sum);
	}
	
}
