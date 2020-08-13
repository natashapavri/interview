package google;

public class DistinctSubsequences {

	public static void main(String[] args) {
		String a = "rabbbiot";
		String b = "rabbit";

		int max = 0;
		int[] a_hash = new int[256];
		int[] b_hash = new int[256];

		if (a.length() == b.length())
			max = 1;
		else {
			for (char c : b.toCharArray()) {
				b_hash[c]++;
			}
			for (char c : a.toCharArray()) {
				a_hash[c]++;
			}

			for (int i = 0; i < 256; i++) {
				if (a_hash[i] > b_hash[i]) {
					max += a_hash[i];
				} else if (a_hash[i] != 0 && b_hash[i] == 0) {
					max += a_hash[i];
				}
			}
		}
		System.out.println(max);
	}
}
