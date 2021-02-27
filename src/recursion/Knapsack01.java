package recursion;

public class Knapsack01 {

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length; 
        
        int maxValue = knapsack(val, wt, W, n - 1);
        
        System.out.println(maxValue);
	}

	private static int knapsack(int[] val, int[] wt, int w, int n) {
		if(n==0 || w ==0) return 0;
		
		if(wt[n] > w) {
			return knapsack(val, wt, w, n-1);
		} else {
			// include nth item
			//not include nth item
			return Math.max(val[n] + knapsack(val, wt, w-wt[n], n-1), knapsack(val, wt, w, n-1));
		}
	}
}
