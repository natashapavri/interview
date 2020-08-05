package arrays;

import java.util.Arrays;

public class FirstLastOccurinArray {

	int findOccurance(int[] numbers, int x, boolean isFirst) {
		if(isFirst) {
			for(int i = 0; i<numbers.length ; i++) {
				if(numbers[i] == x) return i;
			}
		}
		else {
			for(int i = numbers.length -1; i>=0; i--) {
				if(numbers[i] == x) return i;
			}
		}
		return -1;
	}
	
	int[] findStartEndIndex(int[] numbers, int find) {
		Arrays.sort(numbers);
		
		int[] result = {-1, -1};
		int left = 0;
		int right = numbers.length -1;
		
		while(right > left) {
			int mid = (right - left)/2;
			if(find == numbers[mid]) {
				result[0] = mid;
				left = mid +1;
				while(numbers[left] == find) {
					left++;
				}
				result[1] = left - 1;
				break;
			}
			else if(find > numbers[left]) {
				left = mid;
			} else {
				right = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,3,4,5,67,8,5};
		FirstLastOccurinArray obj = new FirstLastOccurinArray();
		System.out.println("First = "+ obj.findOccurance(numbers, 5, true));
		System.out.println("Last = "+ obj.findOccurance(numbers, 5, false));
		int[] result = obj.findStartEndIndex(numbers, 5);
		for(int i : result) {
			System.out.print(i + ", ");
		}
	}
}
