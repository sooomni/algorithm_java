import java.io.*;
import java.util.*;

public class Main2 {

	private static char [] input;
	private static char [] arr;
	private static List <char []> result;
	private static int l,c;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());	
		
		input = new char[c];
		arr = new char[c];
		result = new ArrayList<char []>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<c;i++) {
			input[i] = st.nextToken().charAt(0);
		}

		combination(l,0,0);
		
		Collections.sort(result, new Comparator<char []>() {

			@Override
			public int compare(char[] o1, char[] o2) {
				Arrays.sort(o1);
				Arrays.sort(o2);
				
				return String.valueOf(o1).compareTo(String.valueOf(o2));
			}
			
		});
		
		for(char [] tmp: result) {
			for(char c :tmp) {
				System.out.print(c);
			}
			System.out.println();
		}
		
	}
	
	private static void combination(int m, int target, int index){
		if(m == 0) {
			if(check(arr)) {
				char [] tmp = arr.clone();
				result.add(tmp);
			}
			return;
		}
		
		if(target == c) return;
		
		arr[index] = input[target];
		combination(m-1,target+1,index+1);
		combination(m,target+1,index);
		
	}
	
	private static boolean check(char [] arr) {
		int cnt = 0, cnt2 = 0;
		for(char c : arr){
			if(c == 'a' || c == 'e'|| c == 'i'||c == 'o' || c == 'u') cnt++;
			else cnt2++;
		}
		return cnt >= 1 && cnt2 >= 2 ? true :false;

	}
}