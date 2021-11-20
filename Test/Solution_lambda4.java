import java.util.*;
import java.io.*;

public class Solution_lambda4{

	public static void simulate(int[][] m, int r, int c)
	{	
		int [] dx = {0, 0, -1, 1}; //오른쪽 왼쪽 위 아래
		int [] dy = {1,-1, 0, 0};
		
		HashMap <String,String> policyChange = new HashMap<>() {
			{	
				put("right", "down");
				put("down", "left");
				put("up","right");
				put("left","up");
			}
		};
		
		boolean filled = false;
		int fillNum = 1;
		int rIdx = 0;	
		int cIdx = 0;
		String policy = "right";
		String newPolicy = "";
		
		
		while(!filled) {
			m[rIdx][cIdx] = fillNum++;

			int location = checkLocation(policy);
			int newrIdx = rIdx +dx[location];
			int newcIdx = cIdx +dy[location];
			
			if(isBumped(newrIdx, newcIdx, r, c, m)) {
				newPolicy = policyChange.get(policy);
				location = checkLocation(newPolicy);
				newrIdx = rIdx +dx[location];
				newcIdx = cIdx +dy[location];
				
				if(isBumped(newrIdx, newcIdx, r, c, m)) {
					filled = true;
					return;
				}
				else {
					policy = newPolicy;
					rIdx = newrIdx;
					cIdx = newcIdx;
				}
			} 
			else {
				rIdx = newrIdx;
				cIdx = newcIdx;
			}
			
		}
		
	}

	public static boolean isBumped(int newrIdx, int newcIdx, int r, int c, int [][] m) {
		if(newrIdx < 0 || newrIdx >= r || newcIdx< 0 || newcIdx >= c)  return true;
		else if(m[newrIdx][newcIdx] != 0) return true;
		else return false;
	}
	public static int checkLocation(String policy) {			
		switch(policy) {
			case "right" : return 0;
			case "left" : return 1;
			case "up" : return 2;
			case "down" : return 3;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		int caseNum = scanner.nextInt();

		for(int caseIndex = 1; caseIndex <= caseNum; caseIndex++)
		{
			int r = scanner.nextInt();
			int c = scanner.nextInt();

			int[][] m = new int[r][c];

			simulate(m, r, c);

			writer.write(String.format("Case #%d\n", caseIndex));

			for(int i = 0 ; i < r ; i ++)
			{
				for(int j = 0 ; j < c ; j++)
				{
					if(j > 0)
						writer.write(" ");
					writer.write(String.format("%d", m[i][j]));
				}
				writer.write("\n");
				writer.flush();
			}
		}
		writer.close();
	}
}