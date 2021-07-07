import java.util.*;
import java.io.*;

public class Solution_0704_1 {
	  
	   public static void main(String [] args) {
		   int[] prices = {13000, 88000, 10000};
		   int[] discounts = {30, 20};
		   
		   System.out.println(solution(prices,discounts));
	   }
	
	       public static int solution(int[] prices, int[] discounts) {
	           int answer = 0;
	           
	           Integer[] convertPrices = Arrays.stream(prices).boxed().toArray(Integer[]::new);
	           Integer[] convertDiscounts= Arrays.stream(discounts).boxed().toArray(Integer[]::new);
	           
	           Arrays.sort(convertPrices,Collections.reverseOrder()); 
	           Arrays.sort(convertDiscounts,Collections.reverseOrder()); 

	           int count = 0;
	           while(count < convertPrices.length){
	               if(count < discounts.length) answer += (convertPrices[count] * (1 - Float.valueOf(convertDiscounts[count])/100));
	               else answer += convertPrices[count];
	               count+=1;
	           }
	           
	           return answer;
	       }
	       
	  
}
