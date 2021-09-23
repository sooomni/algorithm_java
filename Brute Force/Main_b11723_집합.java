import java.io.*;
import java.util.*;

public class Main_b11723_집합{
	private static int n,m;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashSet <Integer> hs = new HashSet();
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int tmp;
			switch(cmd) {				
				case "add" :{
					tmp = Integer.parseInt(st.nextToken());
					if(hs.contains(tmp)) break;
					hs.add(tmp);
					break;
				}
				case "remove" :{			
					tmp = Integer.parseInt(st.nextToken());
					if(!hs.contains(tmp)) break;
					hs.remove(tmp);
					break;
				}
				case "check" :{
					tmp = Integer.parseInt(st.nextToken());
					if(hs.contains(tmp)) sb.append("1"+"\n");
					else sb.append("0"+"\n");					
					break;
				}
				case "toggle" :{
					tmp = Integer.parseInt(st.nextToken());
					if(hs.contains(tmp)) {
						hs.remove(tmp);
						break;
					}
					else {
						hs.add(tmp);
						break;
					}
				}
				case "all" :{
					hs.clear();
					hs = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
					break;
				}
				case "empty" :{
					hs.clear();
					break;
				}
			}

		}
		
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}