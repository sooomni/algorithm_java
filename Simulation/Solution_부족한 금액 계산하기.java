class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        for(int i = 1;i<=count;i++){
            answer += (price * i);
        }
        
        return Math.max(answer - money,0);
    }
}