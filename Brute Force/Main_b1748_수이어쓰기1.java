import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_b1748_수이어쓰기1 {

	private static int n;
	private static int ans = 0;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		//내 풀이
		//자릿수를 먼저 구하고 
		//(120             				-100+1) * 3 3자리 수 
		//(120 -(120-100+1)				 -10+1) * 2 2자리 수 
		//(120 -(120-(120-100+1)-10+1)    -1+1) * 1 1자리 수 
		int tmp = n;
		int cnt = 1;

		while(tmp/10 != 0) {
			cnt++;
			tmp /= 10;
		}

		for(int i = cnt-1;i>=0;i--) {
			tmp = (n -  (int)(Math.pow(10, i)+1));
			ans += tmp * cnt;
			cnt -= 1;
			n -= tmp;	
		}
		
		// 다른 풀이
		// 쭉 문자열로 해서 더할 것이기 떄문에 
		// 1의 자리는 120개
		// 2의 자리는 120-9 (전체-일의 자리의 수)
		// 3의 자리는 120-99 (전체-십의 자리의 수)
		
        int ans=0;
        for(int i=1; i<=n; i*=10){
            ans += n - (i-1);
        }

		System.out.println(ans);
	}
	
}