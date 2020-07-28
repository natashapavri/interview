package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DelayedProject {

	public static void main(String[] args) {
		int[][] projects = { {}, { 0 }, { 1, 4 }, { 2, 5 }, { 0 }, { 4 }, { 5 } };
		List<Integer> delays = new ArrayList<>(Arrays.asList(5));

		List<Integer> pathOfExecution = new LinkedList<Integer>();

		List<Integer> temporaryMarks = new ArrayList<>();
		List<Integer> permanentMarks = new ArrayList<>();

		for (int i = 0; i < projects.length; i++) {
			if (!permanentMarks.contains(i)) {
				findPath(i, projects, temporaryMarks, permanentMarks, pathOfExecution);
			}
		}

		for (Integer c : pathOfExecution) {
			if (delays.contains(c)) {
				pathOfExecution = pathOfExecution.subList(0, pathOfExecution.indexOf(c));
				break;
			}
		}
		
		for(Integer c : pathOfExecution) {
			System.out.print(c + "-->");
		}

	}

	private static void findPath(Integer i, int[][] projects, List<Integer> temporaryMarks, List<Integer> permanentMarks,
			List<Integer> pathOfExecution) {

		if (temporaryMarks.contains(i))
			throw new IllegalArgumentException();

		if (!permanentMarks.contains(i)) {
			temporaryMarks.add(i);
			
			for (Integer p : projects[i]) {
				findPath(p, projects, temporaryMarks, permanentMarks, pathOfExecution);
			}

			permanentMarks.add(i);
			temporaryMarks.remove(i);
			pathOfExecution.add(i);
		}

	}

}
