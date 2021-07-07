import java.util.*;
import java.io.*;

public class Solution_0704_3 {

	public static void main(String [] args) {
		System.out.println(solution("aaaaabbbbb","ab"));
	}
	
	public static int solution(String s, String t) {
	        int result = 0;
	        
	        while(s.contains(t)){
	        	result+=1;
	        	s = convert(s,t);
            }
	        
	        return result;
	    }
	    
	    public static String convert(String s, String t){
            int target = 0;
            for(int i = 0;i<s.length()-t.length();i++){
               int tIndex = 0;
               for(int j = i;j<(i+t.length());j++){
                   if(s.charAt(j) != t.charAt(tIndex)) {tIndex = -1; break;};
                   tIndex++;
               }
               if(tIndex != -1) target = i; 
            }
            
            String sTemp = "";
            sTemp += s.substring(0,target);   
            sTemp += s.substring(target+t.length());  
	        return sTemp;
	    }
}