public class LoadBalancer {

	public static void main(String[] args) {
		int[] processes = {5,3,4,2,1};
		int sum = 0;
		int servers = 2;
		for(int i : processes) {
			sum+=i;
		}
		double target = sum/servers;
		int[][] dp = new int[processes.length+1][sum + 1];
		for(int i = 0; i<=processes.length;i++) {
			dp[i][0] = 1;
		}
		for(int j = 0; j<=target;j++) {
			dp[0][j] = 1;
		}
		
		int N = Integer.MAX_VALUE;
		for(int i =1;i<=processes.length;i++) {
			for(int j =1;j<=target;j++) {
				if(j>=processes[i-1]) {
					dp[i][j] = dp[i-1][j]+dp[i-1][j-processes[i-1]];
				} else {
					dp[i][j] = dp[i-1][j];
				}
				if(dp[i][j]>=1) {
					N = Math.min(N, j);
				}
			}
			
		}
		
		System.out.println(N);
	}
	
	
}