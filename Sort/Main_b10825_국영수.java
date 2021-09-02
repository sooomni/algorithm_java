import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 객체의 비교 기준을 제공한다.
 * Comparable 인터페이스 
 *   - compareTo 메소드를 구현
 *   - 자기 자신과 매개변수 객체 구현
 * 	
 * Comparator 인터페이스 
 *   - compare 메소드 구현
 *   - 두 매개변수를 구현
 *   - util 패키지에 있어 import 필요 
 * 
 * 
 */
class Student implements Comparable<Student>{
	public String name;
	public int kor_score;
	public int eng_score;
	public int mth_score;

	Student(String name, int kor_score, int eng_score, int mth_score){
		this.name = name;
		this.kor_score = kor_score;
		this.eng_score = eng_score;
		this.mth_score = mth_score;

	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Student stud1) {
	
		if(this.kor_score != stud1.kor_score) {
			//return this.kor_score < stud1.kor_score ? 1: -1;
			return stud1.kor_score - this.kor_score;
		}
		
		if(this.eng_score != stud1.eng_score) {
			//return this.eng_score > stud1.eng_score ? 1 : -1;
			return this.eng_score - stud1.eng_score;
			
		}
		
		if(this.mth_score != stud1.mth_score) {
			//return mth_score < stud1.mth_score ? 1 : -1;
			return stud1.mth_score - this.mth_score;
		}
		
		return this.name.compareTo(stud1.name);
	}

}

public class Main_b10825_국영수 {

	private static int n;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		n = Integer.parseInt(st.nextToken());

		Student [] stud_arr = new Student[n];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			String tmpName = st.nextToken();
			int tmpScore1 = Integer.parseInt(st.nextToken());
			int tmpScore2 = Integer.parseInt(st.nextToken());
			int tmpScore3 = Integer.parseInt(st.nextToken());
			
			Student tempStud = 	new Student(tmpName, tmpScore1, tmpScore2, tmpScore3);
			stud_arr[i] = tempStud;
			
		}
		
	    Arrays.sort(stud_arr);
	    
	    for(Student s : stud_arr) {
            sb.append(s.name).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
	}
}

