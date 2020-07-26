public class SlidingWindow {

	public static void main(String[] args) {
		int[] trees = {1,2,3,2,2};
		int n = trees.length;
		int k = 2;
		// n must be greater 
        if (n < k) { 
            System.out.println("Invalid"); 
        } 
  
        // Compute sum of first window of size k 
        int max_sum = 0; 
        for (int i = 0; i < k; i++) 
            max_sum += trees[i]; 
  
        // Compute sums of remaining windows by 
        // removing first element of previous 
        // window and adding last element of 
        // current window. 
        int window_sum = max_sum; 
        for (int i = k; i < n; i++) { 
            window_sum += trees[i] - trees[i - k]; 
            max_sum = Math.max(max_sum, window_sum); 
        } 
  
       System.out.println(max_sum);
	}
}
