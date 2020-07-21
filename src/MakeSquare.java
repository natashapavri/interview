
public class MakeSquare {

	public static void main(String[] args) {
		boolean[][]arr = {{true, true, false},{false, true, true},{true, true, true},{true, true, false}};
		
		int[][]cache = new int[arr.length][arr[0].length];
		int max = 0;
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]) {
					max = Math.max(max, findSquare(arr, cache, i, j));
				}
			}
		}
		System.out.println(max);
	}

	private static int findSquare(boolean[][] arr, int[][] cache, int i, int j) {
		if(i == arr.length || j == arr[0].length) return 0;
		if(!arr[i][j]) return 0;
		if(cache[i][j] > 0) return cache[i][j];
		cache[i][j] = 1 + Math.min(Math.min(findSquare(arr, cache, i+1, j), findSquare(arr, cache, i, j+1)), findSquare(arr, cache, i+1, j+1));
		return cache[i][j];
	}
	
	
}
