class Solution {
    String answer = "";
    
    public String solution(int[][] scores) {
        
       for(int stud = 0;stud<scores.length;stud++){
            float sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
           
            for(int index = 0;index <scores.length;index++){
                if(index == stud) continue;
                
                if(scores[index][stud] < min) {
                    min = scores[index][stud];
                }
                else if(scores[index][stud] > max) {
                    max = scores[index][stud];
                }
                sum += scores[index][stud];
            }     
           
           if(min > scores[stud][stud] || max < scores[stud][stud]){                
                markResult(sum / (scores.length-1));             
           }
           else {
               sum += scores[stud][stud];
               markResult(sum / scores.length);
           }
       }
        return answer;
    }
    
    public void markResult(float score){
        if(score >= 90){
            answer += "A";
        }
        else if(score>= 80){
            answer += "B";
        }
        else if(score>= 70){
            answer += "C";
        }
        else if(score>= 50){
              answer += "D";
        }
        else{
              answer += "F";
        }
    }
}