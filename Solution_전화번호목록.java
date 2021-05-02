import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
       Arrays.sort(phone_book);
       for(int i = 0;i<phone_book.length;i++){
           int size = phone_book[i].length();
           for(int j = i+1;j<phone_book.length;j++){
               if(phone_book[j].length() <= size) break;
               if(phone_book[j].substring(0,size).equals(phone_book[i])) return false;
           }
       }
        return true;
    }
}