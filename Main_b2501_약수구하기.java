import java.io.*;
import java.util.*;

public class Main {

	public static void main(String [] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i  = 1;i<= n;i++) {
			if(n % i == 0) arr.add(i);
		}
		
		if(arr.size() < k)
			System.out.println(0);
		else {
			Collections.sort(arr);
			System.out.println(arr.get(k-1));
		}
	}
}