package leetcode.google;

public class CoresBalance {

	public static void main(String[] args) {
		int[] cores = { 2, 4 };
		int[] tasks = { 1, 1, 4 };
		boolean possible = findBalance(cores, tasks, 0);
		System.out.println(possible);
	}

	//back-tracking
	private static boolean findBalance(int[] cores, int[] tasks, int t) {
		if (t == tasks.length)
			return true;

		for (int i = 0; i < cores.length; i++) {
			if (cores[i] >= tasks[t]) {
				cores[i] -= tasks[t];
				if (findBalance(cores, tasks, t + 1)) {
					return true;
				}
				cores[i] += tasks[t];
			}
		}

		return false;
	}
}
