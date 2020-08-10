package google;

import java.util.ArrayList;
import java.util.List;

public class SudokuValid {

	public static void main(String[] args) {
		String[] puzzle = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
				"...419..5", "....8..79" };

		char[][] gridPuzzle = new char[9][9];
		makeGridPuzzle(puzzle, gridPuzzle);

		boolean valid = checkValidity(gridPuzzle);

		System.out.println(valid);

	}

	private static boolean checkValidity(char[][] gridPuzzle) {
		if (checkRowValidity(gridPuzzle) && checkColumnValidity(gridPuzzle) && checkSquareValidity(gridPuzzle)) {
			return true;
		}

		return false;
	}

	private static boolean checkSquareValidity(char[][] gridPuzzle) {
		for (int b = 0; b < 9; b++) {
			List<Character> squares = new ArrayList<>();
			int count = 0;
			for (int i = b / 3 * 3; i < b / 3 * 3 + 3; i++) {
				for (int j = b % 3 * 3; j < b % 3 * 3 + 3; j++) {
					if(gridPuzzle[i][j] == '.') {
						count++;
					}
					else {
						if(squares.contains(gridPuzzle[i][j])) {
							return false;
						}
						else {
							squares.add(gridPuzzle[i][j]);
						}
					}
				}
			}
			if(count + squares.size() != 9) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkColumnValidity(char[][] gridPuzzle) {
		for (int j = 0; j < gridPuzzle[0].length; j++) {
			List<Character> numbers = new ArrayList<Character>();
			int count = 0;
			for (int i = 0; i < gridPuzzle.length; i++) {
				if (gridPuzzle[i][j] == '.') {
					count++;
				} else {
					if (numbers.contains(gridPuzzle[i][j])) {
						return false;
					} else {
						numbers.add(gridPuzzle[i][j]);
					}
				}
			}
			if (count + numbers.size() != 9) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkRowValidity(char[][] gridPuzzle) {

		for (int i = 0; i < gridPuzzle.length; i++) {
			List<Character> numbers = new ArrayList<Character>();
			int count = 0;
			for (int j = 0; j < gridPuzzle[0].length; j++) {
				if (gridPuzzle[i][j] == '.') {
					count++;
				} else {
					if (numbers.contains(gridPuzzle[i][j])) {
						return false;
					} else {
						numbers.add(gridPuzzle[i][j]);
					}
				}
			}
			if (count + numbers.size() != 9) {
				return false;
			}
		}

		return true;
	}

	private static void makeGridPuzzle(String[] puzzle, char[][] gridPuzzle) {
		int i = 0;
		for (String row : puzzle) {
			int j = 0;
			for (char c : row.toCharArray()) {
				gridPuzzle[i][j] = c;
				j++;
			}
			i++;
		}
	}

}
