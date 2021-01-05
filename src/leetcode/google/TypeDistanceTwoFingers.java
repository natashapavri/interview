package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class TypeDistanceTwoFingers {

	public static void main(String[] args) {
		String word = "HAPPY";
		Map<Integer, Pair<Integer>> keyboard = new HashMap<Integer, Pair<Integer>>();
		char c = 'A';
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6 && c <= 'Z'; j++) {
				keyboard.put(c - 'A', new Pair<Integer>(i, j));
				c++;
			}
		}
		Integer[][][]dp = new Integer[27][27][word.length()];
		int distance = findMinimum(keyboard, word, dp, 26, 26, 0);
		System.out.println(distance);
	}

	private static int findMinimum(Map<Integer, Pair<Integer>> keyboard, String word, Integer[][][] dp, int f1, int f2, int index) {
		if(index >= word.length()) return 0;
		
		if(dp[f1][f2][index] != null) {
			return dp[f1][f2][index];
		}
		Pair<Integer> pf1 = keyboard.get(f1);
		Pair<Integer> pf2 = keyboard.get(f2);
		Pair<Integer> pcurr = keyboard.get(word.charAt(index) - 'A');
		
		int df1 = (f1 == 26) ? 0 : (Math.abs(pcurr.getX() - pf1.getX()) + Math.abs(pcurr.getY() - pf1.getY()));
		int df2 = (f2 == 26) ? 0 : (Math.abs(pcurr.getX() - pf2.getX()) + Math.abs(pcurr.getY() - pf2.getY()));
		
		int distance = Math.min(findMinimum(keyboard, word, dp, word.charAt(index) - 'A', f2, index + 1) + df1
				, findMinimum(keyboard, word, dp, f1, word.charAt(index) - 'A', index + 1) + df2);
		dp[f1][f2][index] = distance;
		
		return distance;
	}
}
class Pair<T> {
	private T x;
	private T y;
	
	public Pair(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
}
