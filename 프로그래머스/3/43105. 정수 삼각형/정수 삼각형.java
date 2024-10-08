class Solution {
    public int solution(int[][] triangle) {
        int maxSize = triangle[triangle.length-1].length;
        int[][] answer = new int[triangle.length][maxSize];
        
        answer[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++){
            for(int j=0; j<triangle[i].length; j++){
                answer[i+1][j] = Math.max(answer[i+1][j], triangle[i+1][j] + answer[i][j]);
                answer[i+1][j+1] = Math.max(answer[i+1][j+1], triangle[i+1][j+1] + answer[i][j]);
            }
        }
        
        int max = 0;
        for(int i=0; i<maxSize; i++){
            max = Math.max(max, answer[triangle.length-1][i]);
        }
            
        return max;
    }
}