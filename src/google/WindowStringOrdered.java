package google;

public class WindowStringOrdered {

	public static void main(String[] args) {
		String S = "abcdebdde";
		String T = "bde";

		int[][] matrix = new int[S.length() + 1][T.length() + 1];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = i + 1;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (S.charAt(i -1) == T.charAt(j-1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}

		int start = -1;
		int end = S.length();
		
		for(int i = 1; i<matrix.length; i++) {
			if(matrix[i][T.length()] != 0 && (i - (matrix[i][T.length()] - 1)) < (end - start)) {
				start = matrix[i][T.length()] - 1;
				end = i;
			}
		}
		
		if(start!=-1) {
			System.out.println(S.substring(start, end));
		} else {
			System.out.println("-1");
		}
	}
}
