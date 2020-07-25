import java.util.HashMap;
import java.util.Map;

public class SplitStringUniquely {

	public static void main(String[] args) {
		String str = "bac";
		Map<Character, Integer> left = new HashMap<Character, Integer>();
		Map<Character, Integer> right = new HashMap<Character, Integer>();
		
		for(int i =0 ;i<str.length();i++) {
			char c = str.charAt(i);
			int freq = right.getOrDefault(c, 0);
			right.put(c, freq+1);
		}
		
		int count = 0;
		for(int i =0 ;i<str.length();i++) {
			char c = str.charAt(i);
			if(right.containsKey(c)) {
				int freq = right.get(c);
				right.put(c, freq-1);
			}
			if(right.get(c) == 0) right.remove(c);
			
			int freq = left.getOrDefault(c, 0);
			left.put(c, freq+1);
			
			if(left.keySet().equals(right.keySet())) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
