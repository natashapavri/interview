package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfusingNumber {

	/** Confusing number - a number which when rotated 180 gives another meaningful number
	 * Only numbers which rotate meaningfully are 0, 1, 6, 8, 9
	 */
	public static void main(String[] args) {
		int input = 8000;

		List<Integer> valid = new ArrayList<Integer>(Arrays.asList(0, 1, 6, 8, 9));
		Map<Integer, Integer> rotateMap = new HashMap<>();
		rotateMap.put(0, 0);
		rotateMap.put(1, 1);
		rotateMap.put(6, 9);
		rotateMap.put(8, 8);
		rotateMap.put(9, 6);
		
		//given an input - if it is a confusing number print its rotated 180 number
		confusingNumber1(input, valid, rotateMap);
		
		//given N print the number of confusing numbers from 0 to N
		int N = 100;
		confusingRange(N, 0, valid, rotateMap);
		System.out.println(result);
	}

	static int result = 0;
	private static void confusingRange(int n, int current, List<Integer> valid, Map<Integer, Integer> rotateMap) {
		
		if(confusingNumber1(current, valid, rotateMap)) {
			result++;
		}
		for(Integer i : rotateMap.keySet()) {
			int next = current * 10 + i;
			if(next <= n && next != 0) {
				confusingRange(n, next, valid, rotateMap);
			}
		}
	}

	private static boolean confusingNumber1(int input, List<Integer> valid, Map<Integer, Integer> rotateMap) {
		int sum = 0;
		while(input > 0) {
			int digit = input % 10;
			if(valid.contains(digit)) {
				sum = sum * 10 + rotateMap.get(digit);
			} else {
				sum = -1;
				break;
			}
			input = input / 10;
		}
		if(sum == -1) {
			System.out.println("Invalid");
			return false;
		} else {
			System.out.println(sum);
			return true;
		}
	}
}
