import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int num = clothes.length;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0;i<num;i++){
            if(map.containsKey(clothes[i][1])){
               int cur = map.get(clothes[i][1]);
               map.put(clothes[i][1], cur+1);
            }
            else map.put(clothes[i][1],1);
        }
        int temp = 1;

        for(String key : map.keySet()){
            temp *= (map.get(key));
            answer += temp;
        }
        return answer-1;
    }

}

