class Solution_숫자_문자열과_영단어 {
    public int solution(String s) {
        int answer = 0;
        String [] strArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i = 0;i<10;i++){
            s = s.replaceAll(strArr[i],Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}