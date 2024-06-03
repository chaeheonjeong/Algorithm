class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                maxWidth = Math.max(maxWidth, sizes[i][0]);
                maxHeight = Math.max(maxHeight, sizes[i][1]);
            } else {
                maxWidth = Math.max(maxWidth, sizes[i][1]);
                maxHeight = Math.max(maxHeight, sizes[i][0]);
            }
        }
        
        answer = maxWidth * maxHeight;
        
        return answer;
    }
}