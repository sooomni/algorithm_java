import java.io.*;
import java.util.*;

public class Main_b17826_나의학점은 {

	private static int n;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		ArrayList <Integer> arr = new ArrayList<>();
		
		for(int i = 0;i<50;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int target = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<arr.size();i++) {
			if(target == arr.get(i)) {
				System.out.println(takeScore(i+1));
				break;
			}
		}
}
	
	static String takeScore(int input) {
		String score = "";
		
		if(input >= 1 && input <= 5) score = "A+";
		else if (input <= 15) score = "A0";
		else if (input <= 30) score = "B+";
		else if (input <= 35) score = "B0";
		else if (input <= 45) score = "C+";
		else if (input <= 48) score = "C0";
		else if (input <= 50) score = "F";
		
		return score;
	}
}