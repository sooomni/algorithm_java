import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution_lambda2 {
	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String id = sc.next();
		String pw1 = sc.next();
		String pw2 = sc.next();

		if(!Pattern.matches("^[a-z0-9]{3,20}$", id)) {
			System.out.println("fail");
			return;
		}
		else if(!Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$]).{8,20}$", pw1) && pw1.equals(pw2)){
			System.out.println("fail");
			return;
		}
		
		System.out.println("pass");
	}	
}