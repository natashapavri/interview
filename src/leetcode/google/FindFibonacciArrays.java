package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class FindFibonacciArrays {

	public static void main(String[] args) {
		String input = "123456579";
		List<Integer> fibArrays = new ArrayList<>();
		fibArrays = backtrack(input, 0, fibArrays);
		String result = new String();
		for(int i : fibArrays) {
			result = result + i;
		}
		if(result.equals(input)) System.out.println("Fib found");
	}

	private static List<Integer> backtrack(String s, int start, List<Integer> list) {
        if (start >= s.length()) {
            return new ArrayList<>(list);
        }
        long cur = 0;
        for (int i = start; i < s.length(); i++) {
            cur = (cur * 10L) + (long)(s.charAt(i) - '0');
            
            // list size should be 3 because we have n1 + n2 = n3 in any fibonacci sequence
            if (list.size() < 2 || list.get(list.size() - 1) + list.get(list.size() - 2) == (int)cur) {
                list.add((int)cur);
                List<Integer> next = backtrack(s, i + 1, list);
                //atleast 3 nums in a fibonacci series is needed
                if (next.size() > 2) {
                    return next;
                }
                list.remove(list.size() - 1);
            }
            
        }
        return new ArrayList<>();
    }
}
