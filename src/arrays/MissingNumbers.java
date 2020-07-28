package arrays;

public class MissingNumbers {

	public static void main(String[] args) {
		int[] arr1 = {2,3,5,1}; // return 4;
		int[] arr2 = {2,3,5}; // return 4, 1;
		
		int missingOneNumber = findMissingNumber(arr1);
		System.out.println(missingOneNumber);
		
		int[] missing = findMissingNumbers(arr2);
		for(int i=0;i<missing.length;i++) {
			System.out.println(missing[i]);
		}
	}

	private static int[] findMissingNumbers(int[] arr2) {
		int expectedSize = arr2.length+2;
		long expectedSum = expectedSize*(expectedSize+1)/2;
		
		long totalSum = 0;
		for(int i: arr2) {
			totalSum+=i;
		}
		long pivot = (expectedSum - totalSum)/2;
		int expectedLeftXor =0, expectedRightXor = 0;
		int actualLeftXor=0, actualRightXor = 0;
		for(int i =1;i<=expectedSize; i++) {
			if(i<=pivot) {
				expectedLeftXor^=i;
			} else {
				expectedRightXor^=i;
			}
		}
		for(int i : arr2) {
			if(i <= pivot) {
				actualLeftXor^=i;
			} else {
				actualRightXor^=i;
			}
		}
		int missing1 = expectedLeftXor^actualLeftXor;
		int missing2 = expectedRightXor^actualRightXor;
		int [] result = {missing1, missing2};
		return result;
	}

	private static int findMissingNumber(int[] arr1) {
		int expectedXor = 0;
		int arrXor = 0;
		for(int i: arr1) {
			arrXor^=i;
		}
		for(int i=1;i<=arr1.length+1;i++) {
			expectedXor^=i;
		}
		return expectedXor^arrXor;
	}
}
