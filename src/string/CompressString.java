package string;

public class CompressString {

	public static void main(String[] args) {
		String input = "aaabbbcc";
		String output = compressString(input);
		
		System.out.println(output);
	}

	private static String compressString(String input) {
		StringBuilder sb = new StringBuilder();
		
		int sum = 1;
		for(int i = 0; i < input.length(); i++) {
			if(i == input.length() - 1) {
				sb.append(input.charAt(i)).append(sum);
			}
			else if(input.charAt(i) == input.charAt(i+1)) {
				sum++;
			} else {
				sb.append(input.charAt(i)).append(sum);
				sum = 1;
			}
		}
		
		return sb.toString();
	}
}
