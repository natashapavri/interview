package arrays;

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
	
	public static void main(String[] args) {
		int[] numbers = {1,3,4,5,67,8,5};
		FirstLastOccurinArray obj = new FirstLastOccurinArray();
		System.out.println("First = "+ obj.findOccurance(numbers, 5, true));
		System.out.println("Last = "+ obj.findOccurance(numbers, 5, false));
	}
}
