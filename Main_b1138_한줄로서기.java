import java.io.*;
import java.util.*;

/*
 * 일자 : 2020.12.26
 * 메모리 :11532 kb	
 * 시간 : 80 ms
*/

public class Main_b1138_한줄로서기 {

	private static int num;
	private static int [] arr;
	private static List <Integer> list;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[num];
		list = new ArrayList<>();
		
		//입력 받
		for(int i = 0;i<num;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//키 내림차 순으로 (4,3,2...) 입력받은 값이 인덱스가 되게 추가하되, 입력 값(인덱스)가 중복되었을 때 를 가졌을 때 더 작은 키의사람이 더 왼쪽에 위치해야 함
		//예제 입력에서 2,3이 똑같이 1을 가지고 있지만 2가 3보다 왼쪽 위치해야 함
		//[4] -> [4,3] -> [4,2,3] -> [4,2,1,3]
		//list의 add는 같은 인덱스에 add할 경우 기존 인덱스 값이 뒤로 밀리고 매개변수 값이 해당 인덱스에 삽입
		
		for(int i = num-1;i>=0;i--)
		{
			list.add(arr[i],i+1);
		}
		
		for(int k :list)
			System.out.print(k+" ");		
	
	}
	
}
