package google;

public class PaintersAllocation {

	public static void main(String[] args) {
		int painters = 10;
		int timePerUnit = 1;
		int[] blocks = { 1, 8, 11, 3 };

		int minTimeTaken = findMinTimeTaken(blocks, painters, timePerUnit);
		System.out.println(minTimeTaken);
	}

	private static int findMinTimeTaken(int[] blocks, int painters, int timePerUnit) {

		int left = Integer.MAX_VALUE;
		int totalTime = 0;
		
		for (int i = 0; i < blocks.length; i++) {
			totalTime += timePerUnit * blocks[i];
			left = Math.min(left, blocks[i] * timePerUnit);
		}
		
		int right = totalTime;
		int minTime = Integer.MAX_VALUE;

		while (right >= left) {
			int mid = left + (right - left) / 2;
			if (isPossible(blocks, painters, timePerUnit, mid)) {
				minTime = Math.min(minTime, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return minTime;
	}

	private static boolean isPossible(int[] blocks, int painters, int timePerUnit, int mid) {

		int paintersRequired = 1;
		int currentTimeTaken = 0;
		int totalTime = mid;

		for (int i = 0; i < blocks.length; i++) {
			if(blocks[i] * timePerUnit > totalTime) {
				return false;
			}
			if((currentTimeTaken + (blocks[i] * timePerUnit)) > totalTime) {
				currentTimeTaken = 0;
				paintersRequired++;
				if(paintersRequired > painters) {
					return false;
				}
			}
			currentTimeTaken+=(blocks[i] * timePerUnit);
		}
		
		return true;
	}
}
