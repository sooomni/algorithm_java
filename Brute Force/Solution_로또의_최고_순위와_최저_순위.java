class Solution_로또의_최고_순위와_최저_순위{
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {1,1};
        int cnt = 0;
        int zeroCnt = 0;

        boolean [] arr = new boolean[46];
        
        for(int i : lottos){
            if(i == 0) {
                zeroCnt++; 
                continue;
            }
            arr[i] = true;
        }
        
        for(int i : win_nums){
            if(arr[i]) cnt++;
        }
        
        if(cnt == 6) return answer;
        else{
            answer[0] = checkRacking(cnt+zeroCnt);
            answer[1] = checkRacking(cnt);
        }
        
        return answer;
    }
    public int checkRacking(int n){
        switch(n){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }
}