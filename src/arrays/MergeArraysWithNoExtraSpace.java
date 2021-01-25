package arrays;

public class MergeArraysWithNoExtraSpace {

	public static void main(String[] args) {
		int[] a = {1,3,5,0,0,0};
		int[]b = {2,4,6};
		int aIndex = 0;
		int bIndex = b.length - 1;
		for(int i = 0; i <a.length; i++) {
			if(a[i] != 0) {
				aIndex++;
			}
		}
		aIndex = aIndex - 1;
		if(aIndex + bIndex > a.length) {
			throw new IllegalArgumentException();
		}
		
		int mergeIndex = a.length - 1;
		
		while(aIndex >= 0 && bIndex >= 0) {
			if(a[aIndex] > b[bIndex]) {
				a[mergeIndex--] = a[aIndex--];
			} else {
				a[mergeIndex--] = b[bIndex--];
			}
		}
		
		while(bIndex >= 0) {
			a[mergeIndex--] = b[bIndex--];
		}
		
		while(aIndex >= 0) {
			a[mergeIndex--] = a[aIndex--];
		}
		
		for(int i : a) {
			System.out.print(i + ", ");
		}
	}
}
