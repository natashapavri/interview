package google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PascalRowGeneration {

	public static void main(String[] args) {
		int k = 5;
		
		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		
		for(int row = 0; row < k; row++) {
			List<Integer> prow = new LinkedList<Integer>();
			int previous = 1;
			for (int col = 0; col <= row; col++) {
				//first value
				if(col == 0) {
					prow.add(1);
					previous = 1;
				}
				// last value
				else if(col == row) {
					prow.add(1);
					previous = 1;
				}
				else {
					// in between
					int value = previous * (row - col + 1) / col;
					prow.add(value);
					previous = value;
				}
			}
			rows.add(prow);
		}
		
		for(List<Integer> row : rows) {
			Iterator<Integer> rowItr = row.iterator();
			while(rowItr.hasNext()) {
				System.out.print(rowItr.next() + "-->");
			}
			System.out.println();
		}
	}
}
