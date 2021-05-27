import java.io.*;
import java.util.*;

public class Main{
	private static int [] input;
	private static int [] output;
	private static boolean print;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		input = new int[9];
		output = new int[9];
		
		for(int i = 0;i<9;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		print = true;
		findsevendwarf(7,0,0,0);
	}
	private static void findsevendwarf(int m,int index, int target,int sum) {
		
		if(m == 0) {
			if(sum == 100 && print) {
				print = false;
				for(int i = 0;i<7;i++) {
					System.out.println(output[i]);
				}
			}
			return;
		}
		
		if(target >= 9 || sum >100) return;
		output[index] = input[target];
		findsevendwarf(m-1,index+1,target+1,sum+input[target]);
		findsevendwarf(m,index,target+1,sum);
	}
}
