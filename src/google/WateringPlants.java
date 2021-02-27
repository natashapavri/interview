package google;

public class WateringPlants {

	public static void main(String[] args) {
		int[] plants = { 2, 4, 5, 1, 2 };
		int capacity1 = 4;
		int capacity2 = 2;

		int left = 0;
		int right = plants.length - 1;

		int can1 = 0, can2 = 0;
		int refill = 0;
		while (left <= right) {
			if (can1 < plants[left]) {
				can1 += capacity1;
				refill++;
			} else {
				can1 -= plants[left];
			}
			if (can2 < plants[right]) {
				can2 += capacity2;
				refill++;
			} else {
				can2 -= plants[right];
			}
			if (left == right) {
				if (can1 < plants[left] && can2 < plants[left]) {
					can1 += capacity1;
					refill++;
				}
			}
			left++;
			right--;
		}
		
		System.out.println(refill);
	}
}
