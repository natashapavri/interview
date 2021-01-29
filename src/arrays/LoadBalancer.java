package arrays;

public class LoadBalancer {

	public static void main(String[] args) {
		int[] processes = { 5, 3, 4, 2, 1 };
		int min = Integer.MAX_VALUE;
		min = findMinimumDiff(processes, 0, 0, processes.length - 1);
		System.out.println(min);
	}

	private static int findMinimumDiff(int[] processes, int s1, int s2, int i) {

		if (i < 0) {
			return Math.abs(s2 - s1);
		}
		int value = processes[i];
		int includeInS1 = findMinimumDiff(processes, s1 + value, s2, i - 1);
		int includeInS2 = findMinimumDiff(processes, s1, s2 + value, i - 1);
		
		return Math.min(includeInS1, includeInS2);
	}

}