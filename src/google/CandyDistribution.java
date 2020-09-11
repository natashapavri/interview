package google;

import java.util.HashSet;
import java.util.Set;

public class CandyDistribution {

	public static void main(String[] args) {
		int[] candies = {1,1,2,2,3,3};
		int n = 2;
		
		Set<Integer> distinctTypes = new HashSet<>();
		for(int i : candies) {
			distinctTypes.add(i);
		}
		
		int choices = Math.min(distinctTypes.size(), candies.length/n);
		System.out.println(choices);
	}
}
