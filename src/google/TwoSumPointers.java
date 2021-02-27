package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumPointers {

	public static void main(String[] args) {
		int[] nums = { 16, -7, 11, 15, 5, 4 };

		List<IndexPairs> indexPairs = new ArrayList<IndexPairs>();
		int targetSum = 9;

		int slidingSum = 0;
		int k = 2;

		for (int i = 0; i < k; i++) {
			slidingSum += nums[i];
			if (slidingSum == targetSum && i != 0) {
				IndexPairs index = new IndexPairs();
				index.setX(nums[i - 1]);
				index.setY(nums[i]);
				indexPairs.add(index);
			}
		}

		for (int i = k; i < nums.length; i++) {
			slidingSum += nums[i] - nums[i - k];
			if (slidingSum == targetSum) {
				IndexPairs index = new IndexPairs();
				index.setX(nums[i - 1]);
				index.setY(nums[i]);
				indexPairs.add(index);
			}
		}

		Collections.sort(indexPairs);

		for (IndexPairs i : indexPairs) {
			System.out.println(i.toString());
		}
	}
}

/**
 * @author Natasha
 *
 */
class IndexPairs implements Comparable<IndexPairs> {
	private int x;
	private int y;

	public IndexPairs() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(IndexPairs o) {
		if (this.getY() == o.getY()) {
			return this.getX() - o.getX();
		}
		return this.getY() - o.getY();
	}

	@Override
	public String toString() {
		return "IndexPairs [x=" + x + ", y=" + y + "]";
	}

}
