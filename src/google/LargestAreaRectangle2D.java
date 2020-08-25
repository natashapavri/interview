package google;

import java.util.Stack;

public class LargestAreaRectangle2D {

	public static void main(String[] args) {
		char[][] matrix = {{'0','1'},{'1','0'}};
		int area = maximalRectangle(matrix);
		System.out.println(area);
	}
	
	private static int maximalRectangle(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;
        
        int area = 0;
    
        int[] dp = new int[matrix[0].length];
        
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                   dp[j] = (matrix[i][j] == '1') ? dp[j] + 1 : 0;
                }
            }
            area = Math.max(area, findHistogramArea(dp));
        }
        
        return area;
    }
    
    private static int findHistogramArea(int[] dp) {
        
        int area = 0;
        int i = 0;
        Stack<Integer> index = new Stack<>();
        while(i < dp.length) {
            if(index.isEmpty() || dp[index.peek()]<=dp[i]) {
                index.push(i++);
            }
            else {
                int top = index.pop();
                int currentArea = dp[top] * (index.isEmpty() ? i : i - index.peek() - 1);
                area = Math.max(area, currentArea);
            }
        }
        
        while(!index.isEmpty()) {
            int top = index.pop();
            int currentArea = dp[top] * (index.isEmpty() ? i : i - index.peek() - 1);
            area = Math.max(area, currentArea);
        }
        
        return area;
    }
}
