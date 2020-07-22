
public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] input = { {11,74,0,93},{40,11,74,7}};
		boolean toeplitz = true;
		if(input.length == 1 || input[0].length == 1) toeplitz = true;
		else {
			for(int i = 0;i<input.length-1;i++) {
				for(int j = 0; j<input[0].length-1;j++) {
					if(input[i][j] != input[i+1][j+1]) {
						toeplitz = false;
						break;
					}
				}
				
			}
		}
		
		System.out.println(toeplitz);
	}
}
