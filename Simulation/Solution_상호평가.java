class Solution {
    String answer = "";
    
    public String solution(int[][] scores) {
        
       for(int col = 0;col<scores.length;col++){
            float sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
           
            for(int row = 0;row <scores.length;row++){
                if(row == col) continue;
                
                min = Math.min(scores[row][col], min);
                max = Math.max(scores[row][col], max);
                
                sum += scores[row][col];
            }     
           
           if(min > scores[col][col] || max < scores[col][col])            
                markResult(sum / (scores.length-1));             
           else 
               markResult((sum + scores[col][col]) / scores.length);
       }
        return answer;
    }
    
    public void markResult(float score){
        if(score >= 90)
            answer += "A";
        else if(score>= 80)
            answer += "B";
        else if(score>= 70)
            answer += "C";
        else if(score>= 50)
            answer += "D";
        else
            answer += "F";
    }
}