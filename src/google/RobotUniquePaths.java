package google;

public class RobotUniquePaths {

	public static void main(String[] args) {
		int a = 2;
		int b = 2;
		
		int[][]dp = new int[a][b];
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = 1;
			}
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		System.out.println(dp[a-1][b-1]);
	}
}
