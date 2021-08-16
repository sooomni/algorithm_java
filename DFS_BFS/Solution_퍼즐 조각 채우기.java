import java.util.*;
import java.io.*;
import java.awt.*;

/*
    1. bfs 돌려 game_board의 빈 자리를 찾아 emptyList에 add
    2. table에서 블럭 모양을 찾아 (bfs()) 빈 자리에 들어갈 수 있는 블럭인지 확인 (find(())
    3. find() : emptyList를 돌면서 회전 시켜 input 블럭과 같으면, emptyList에서 삭제 후 +블럭 개수
    4. rotate() : String인 블럭모양을 배열로 만들기 위해 x,y 개수를 구하고
                  y는 고정, x는 역순으로 돌며 회전 
                  (ex) 3,3인 경우, (2,0)(1,0)(0,0) / (2,1)(1,1)(0,1) / (2,2)(1,2)(0,2))
                  (110    001    110    001
                   010 -> 111 -> 010 -> 111
                   011    100    011    100)
*/

class Solution {
    private int N;
    private ArrayList<String> emptyList = new ArrayList<>();
    private int [] dx = {0,0,-1,1};
    private int [] dy = {-1,1,0,0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        N = table.length;
        
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(game_board[i][j] == 0){
                    emptyList.add(bfs(game_board, i,  j, 0));
                }
            }
        }     
      
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(table[i][j] == 1){
                    answer += find(bfs(table, i,  j, 1));
                }
            }
        }

        return answer;
    } 
    
     public int find(String s) {
        int point = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') point++;
        }

        for(int i = 0; i < emptyList.size(); i++) {
            String str = emptyList.get(i);

            for(int j = 0; j < 4; j++) {
                str = rotate(str);
                if(s.equals(str)) {
                    emptyList.remove(i);
                    return point;
                }
            }
        }
        return 0;
    }
    
     public String rotate(String s) {
        String str = "";
        int x = 0;
        int y = 0;

        for(int i = 0; i < s.length(); i++) {
            if(x == 0) {
                if(s.charAt(i) != ' ') {
                    y++;
                }
            }
            if(s.charAt(i) == ' ') {
                x++;
            }
        }
       
        char[][] arr = new char[x][y];
        StringTokenizer st = new StringTokenizer(s);

        for(int i = 0; i < x; i++) {
            arr[i] = st.nextToken().toCharArray();
        }

        for(int j = 0; j < y; j++) {
            for(int i = x - 1; i >= 0; i--) {
                str += arr[i][j];
            }
            str += " ";
        }

        return str;
    }


    public String bfs(int [][] arr, int i, int j, int m){
        String s = "";
        boolean [][] visited = new boolean[N][N];
        Queue <Point> q = new LinkedList<>();
        
        q.offer(new Point(i,j));
        visited[i][j] = true;
        arr[i][j] = (m+1)%2;
        
        int x_min = i;
        int x_max = i;
        int y_min = j;
        int y_max = j;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            int x =  cur.x;
            int y = cur.y;
            
            x_min = Math.min(x_min,x);
            x_max = Math.max(x_max,x);
            y_min = Math.min(y_min,y);
            y_max = Math.max(y_max,y);
            
            for(int k = 0;k<4;k++){
                int kx = x + dx[k];
                int ky = y + dy[k];
                
                if(kx < 0 || ky < 0 || kx >=  N || ky >= N) continue;
                
                if(arr[kx][ky] == m){
                    visited[kx][ky] = true;
                    arr[kx][ky] = (m+1)%2;
                    q.offer(new Point(kx,ky));
                }
            }
        }
        
        for(int x = x_min; x <= x_max; x++) {
            for(int y = y_min; y <= y_max; y++) {
                s += visited[x][y] ? "1" : "0";
            }
            s += " ";
        }

        return s;
    }

}