import java.io.*;
import java.util.*;

/*
 * 일자 : 2020.12.26
 * 메모리 :12668 kb	
 * 시간 :128 ms
*/

public class Main_b4796_캠핑 {

	private static int L,P,V,result;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 1;
		int temp;
		
		while(true)
		{ 
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			temp = L;
			
			if(L == 0 && P == 0 && V == 0)
				break;
		
			
			temp = (V%P) < L ? (V%P) : L;
			
			//이에 대한 예외케이스 5 8 15
			//나머지가 5보다 클 때 처리를 해주지 않으면 예외케이스에 대한 답은 5 +7 = 12가 되어 오답
			//나머지가 L보다 크다면 실제 사용 가능하지 않은 기간 까지 포함되어 계산
			result = (L*(V/P)) + temp;
			
			System.out.println("Case "+count+": "+result);
			count++;
		}
	
	}
	
}
