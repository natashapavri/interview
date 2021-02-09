package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class CardsInSets {

	public static void main(String[] args) {
		List<int[]> cards = new ArrayList<>();
		int[] c1 = { 2, 0, 1, 2 };
		int[] c2 = { 1, 0, 0, 1 };
		int[] c3 = { 0, 0, 2, 0 };
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);

		boolean isSetAvailable = findSets(cards);
		System.out.println(isSetAvailable);
	}

	private static boolean findSets(List<int[]> cards) {
		
		List<String> possibilites = new ArrayList<>();
		for(int[] c : cards) {
			String s = c[0]+ "," + c[1] + "," + c[2] + "," + c[3];
			possibilites.add(s);
		}
		for(int i = 0; i < cards.size(); i++) {
			for(int j = i + 1; j < cards.size(); j++) {
				int[] c1 = cards.get(i);
				int[] c2 = cards.get(j);
				int[] ec3 = compare(c1, c2);
				String ec2Str = ec3[0]+ "," + ec3[1] + "," + ec3[2] + "," + ec3[3];
				if(possibilites.contains(ec2Str)) return true;
			}
		}
		
		return false;
	}

	private static int[] compare(int[] c1, int[] c2) {
		int[] result = new int[4];
		int xorAll = 0 ^ 1 ^ 2;
		int[] mid = new int[4];
		for(int i = 0; i < c1.length; i++) {
			int xor = c1[i] ^ c2[i];
			mid[i] = xor;
		}
		for(int i = 0; i <mid.length; i++) {
			if(mid[i] == 0) {
				result[i] = c1[i];
			} else {
				result[i] = xorAll ^ mid[i];
			}
		}
		
		return result;
	}
}
