package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class TransformStringtoAnother {

	public static void main(String[] args) {
		String s = "aabcc";
		String t = "ccdee";
		
		boolean canTransform = canBeTransformed(s, t);
		
		System.out.println(canTransform);
	}

	private static boolean canBeTransformed(String s, String t) {
		if(s.length() != t.length()) return false;
		if(s.equals(t)) return true;
		
		Map<Character, Character> alphaMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if(sc != tc) {
				if(alphaMap.containsKey(sc)) {
					if(alphaMap.get(sc) != tc) {
						return false;
					}
				}
				else {
					alphaMap.put(sc, tc);
				}
			}
		}
		
		return true;
	}
}
