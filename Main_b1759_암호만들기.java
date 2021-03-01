import java.io.*;
import java.util.*;

public class Main_b1759_암호만들기 {

	private static String[] input;
	private static int l,c;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());	
		
		input = new String[c];
		
		input = br.readLine().split(" ");
		Arrays.sort(input);
		
		combination(0,"");

	}
	
	private static void combination(int index, String ref){
		if(ref.length() == l) {
			if(check(ref)) {
				System.out.println(ref);
			}
			return;
		}
		
		if(index >= c) return;
		
		combination(index+1,ref+input[index]);
		combination(index+1,ref);
		
	}
	
	private static boolean check(String arr) {
		int cnt = 0, cnt2 = 0;
		for(int i = 0;i<arr.length();i++){
			 if(isVowel(arr.charAt(i))) cnt++;
			 else cnt2++;
		}
		return cnt >= 1 && cnt2 >= 2 ? true :false;

	}
	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'e'|| c == 'i'||c == 'o' || c == 'u') ? true : false;
	}
}