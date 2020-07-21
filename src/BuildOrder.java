import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildOrder {

	public static void main(String[] args) {
		int[][] processes = { {}, { 0 }, { 0 }, { 1, 2 }, { 3 } };

		List<Integer> temporaryMarks = new ArrayList<Integer>();
		List<Integer> permanentMarks = new ArrayList<Integer>();

		LinkedList<Integer> result = new LinkedList<>();

		for (int i = 0; i < processes.length; i++) {
			if (!permanentMarks.contains(i)) {
				visit(i, processes, temporaryMarks, permanentMarks, result);
			}
		}

		for (Integer i : result) {
			System.out.print(i + "-->");
		}
	}

	private static void visit(Integer i, int[][] processes, List<Integer> temporaryMarks, List<Integer> permanentMarks,
			LinkedList<Integer> result) {
		if (temporaryMarks.contains(i)) {
			throw new IllegalArgumentException();
		}

		if (!permanentMarks.contains(i)) {
			temporaryMarks.add(i);

			for (Integer p : processes[i]) {
				visit(p, processes, temporaryMarks, permanentMarks, result);
			}

			permanentMarks.add(i);
			temporaryMarks.remove(i);
			result.add(i);
		}
	}
}
