package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPalindromes {

	public static void main(String[] args) {
		String str = "aabb";
		List<String> output = generatePalindromes(str);
		for (String s : output) {
			System.out.println(s);
		}
	}

	private static List<String> generatePalindromes(String s) {

		Set<String> result = new HashSet<>();

		int[] count = new int[128];

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}

		char middleChar = 0;
		int n = 0;
		boolean oddPicked = false;

		for (int i = 0; i < 128; i++) {
			if (count[i] == 0)
				continue;
			if (count[i] % 2 == 0) {
				count[i] /= 2;
				n += count[i];
			} else {
				if (!oddPicked) {
					middleChar = (char) i;
					oddPicked = true;
					count[i]--;
					count[i] /= 2;
					n += count[i];
				} else {
					return new ArrayList<>();
				}
			}
		}

		findPalindromes(result, count, n, new StringBuilder(), middleChar);

		return new ArrayList<String>(result);
	}

	private static void findPalindromes(Set<String> result, int[] count, int n, StringBuilder sb, char middleChar) {
		if (n == 0) {
			StringBuilder nsb = new StringBuilder(sb);
			if (middleChar != 0)
				nsb.append(middleChar);
			nsb.append(new StringBuilder(sb).reverse());
			result.add(nsb.toString());
		}

		for (int i = 0; i < 128; i++) {
			if (count[i] != 0) {
				count[i]--;
				sb.append((char) i);
				findPalindromes(result, count, n - 1, sb, middleChar);
				count[i]++;
				sb = sb.delete(sb.length() - 1, sb.length());
			}
		}
	}
}
