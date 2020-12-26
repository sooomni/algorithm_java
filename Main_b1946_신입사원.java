import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 일자 : 2020.12.26
 * 메모리 :298960 kb	
 * 시간 :1532 ms
*/

class Person implements Comparable<Person>
{
	int firstscore;
	int secondscore;
	
	public Person(int i, int j) {
		firstscore = i;
		secondscore = j;
	}

	@Override
	public int compareTo(Person o) {
		return this.firstscore > o.firstscore ? 1 : -1;
	}

}

public class Main_b1946_신입사원 {
	
	public static void main(String [] args) throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st;
		int tc  = Integer.parseInt(str);
		int numberOfPerson;
		List <Person> personlist = new ArrayList<>();
		int sum = 1;
		int [] temp = new int[2];
		
		for(int i = 0;i<tc;i++) 
		{
			sum = 1;
			personlist.clear();
			numberOfPerson = Integer.parseInt(br.readLine());		
			
			for(int p = 0;p<numberOfPerson; p++)
			{
				st = new StringTokenizer(br.readLine());
				temp[0] = Integer.parseInt(st.nextToken());
				temp[1] = Integer.parseInt(st.nextToken());
				personlist.add(new Person(temp[0],temp[1]));
			}

			Collections.sort(personlist); 
			
			int rank = personlist.get(0).secondscore;
			
			for(int p = 1;p<numberOfPerson;p++)
			{
				if(personlist.get(p).secondscore < rank)
				{
					rank = personlist.get(p).secondscore;
					sum++;
				}	
			}
			
			System.out.println(sum);
		}
	
	}
}
