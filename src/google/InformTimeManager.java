package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class InformTimeManager {

	public static void main(String[] args) {
		int n = 7;
		int headID = 6;
		int[] manager = { 1, 2, 3, 4, 5, 6, -1 };
		int[] informTime = { 0, 6, 5, 4, 3, 2, 1 };
		int time = numOfMinutes(n, headID, manager, informTime);
		System.out.println(time);
	}

	private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		TreeMap<Integer, List<Integer>> managerToEmployee = new TreeMap<>();
		for (int i = 0; i < manager.length; i++) {
			managerToEmployee.putIfAbsent(manager[i], new ArrayList<>());
			managerToEmployee.get(manager[i]).add(i);
		}

		int currTime = 0;
		int maxTime = Integer.MIN_VALUE;
		Queue<Integer> employees = new LinkedList<Integer>();
		employees.add(headID);
		Queue<Integer> time = new LinkedList<Integer>();
		time.add(0);

		while (!employees.isEmpty()) {
			Integer emp = employees.poll();
			Integer t = time.poll();

			if (managerToEmployee.containsKey(emp)) {
				currTime = t + informTime[emp];
				maxTime = Math.max(maxTime, currTime);
				for(Integer i : managerToEmployee.get(emp)) {
					employees.add(i);
					time.add(currTime);
				}
			}

		}

		return maxTime;
	}

}
