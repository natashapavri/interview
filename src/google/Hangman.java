package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hangman {

	public static void main(String[] args) {
		String secret = "ENGINEER";
		char[] inputs = { 'E', 'G', 'I', 'N', 'S', 'R' };
		int turns = inputs.length;
		
		char[] output = new char[secret.length()];

		for (int i = 0; i < output.length; i++) {
			output[i] = '-';
		}
		
		Map<Character, Set<Integer>> indexMap = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			indexMap.putIfAbsent(secret.charAt(i), new HashSet<>());
			indexMap.get(secret.charAt(i)).add(i);
		}

		for (int i = 0; i < turns; i++) {
			char c = inputs[i];
			
			if(indexMap.containsKey(c)) {
				for(int index : indexMap.get(c)) {
					output[index] = c;
				}
			}
 		}
		
		String outStr = new String(output);
		System.out.println(outStr);
		
		if(outStr.equals(secret)) {
			System.out.println("WINNER WINNER CHICKEN DINNER");
		}
	}
}
