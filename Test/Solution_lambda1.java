import java.io.*;

public class Solution_lambda1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		String[] logs = new String[n];

		for(int i = 0; i <n ; i++)
		{
			logs[i] = br.readLine().trim();
		}
		
		StringBuilder sb = new StringBuilder();
		
		String now = "";
		String prev = logs[0];
		int cnt = 1;
		int size = 1;
		
		for(int i = 1 ; i < n ; ++i){
			now = logs[i];
			
			if(now.equals(prev)) cnt++;		
			else{
				if(cnt != 1)
					sb.append(prev+" ("+cnt+")\n");
				else
					sb.append(prev+"\n");
				
				size++;
				cnt = 1;
				prev = now;
			}
		}

		if(cnt > 1) 
			sb.append(prev+" ("+cnt+")\n");
		else
			sb.append(prev+"\n");
		
		System.out.println(size);
		System.out.println(new String(sb));
	}
}