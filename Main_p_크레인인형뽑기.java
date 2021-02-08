import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack <Integer> s = new Stack<>();
        
        for(int m : moves){
            for(int j = 0;j<board[m-1].length;j++){
                if(board[j][m-1] != 0) {
                    s.push(board[j][m-1]);
                    board[j][m-1] = 0;
                    break;
                }   
            }
                
            if(s.size() >= 2){
                int temp = s.pop();
                if(temp == s.peek()){
                    s.pop();
                    answer+= 2;
                }
                else
                   s.push(temp);   
            }  
        }
        return answer;
    }
}