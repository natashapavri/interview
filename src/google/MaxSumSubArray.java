package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, -7, -2, 3, 4, 1};

		SubArray root = new SubArray();
		root.setUnderlyingArray(nums);
		root.setStart(0);
		root.setEnd(nums.length);

		List<SubArray> results = new ArrayList<SubArray>();
		int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] >= 0) {
				j++;
			} else {
				results.add(root.getSubArray(i, j));
				j++;
				i = j;
			}

		}

		results.add(root.getSubArray(i, j));

		Collections.sort(results);

		System.out.println(results.get(0).getStart() + " : " + results.get(0).getEnd());

	}
}

class SubArray implements Comparable<SubArray> {
	int[] underlyingArray;
	int start;
	int end;

	public int[] getUnderlyingArray() {
		return underlyingArray;
	}

	public void setUnderlyingArray(int[] underlyingArray) {
		this.underlyingArray = underlyingArray;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public SubArray getSubArray(int i, int j) {
		SubArray array = new SubArray();
		array.setUnderlyingArray(underlyingArray);
		array.setStart(start + i);
		array.setEnd(j);
		return array;
	}

	public Integer getLength() {
		return this.end - this.start;
	}

	public Integer getSum() {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += underlyingArray[i];
		}
		return sum;
	}

	@Override
	public int compareTo(SubArray o) {
		if (o.getSum() == this.getSum()) {
			if (o.getLength() != this.getLength())
				return o.getLength() - this.getLength();
			else
				return this.getStart() - o.getStart();
		} else {
			return o.getSum().compareTo(this.getSum());
		}
	}

}
