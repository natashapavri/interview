package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeForKSortedLists {

	// https://www.youtube.com/watch?v=zplklOy7ENo
	// Time complexity = O(N * logK) (N = total number of all elements & K = number of lists)
	// Space complexity = O(K)
	public static void main(String[] args) {
		List<List<Integer>> nums = new ArrayList<>();
		List<Integer> a = Arrays.asList(4,10,15,24,26);
		List<Integer> b = Arrays.asList(0,9,12,20);
		List<Integer> c = Arrays.asList(5,18,22,30);
		
		nums.add(a);
		nums.add(b);
		nums.add(c);
		
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		int max = Integer.MIN_VALUE;
		int range = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		
		for(int  i = 0; i < nums.size(); i++) {
			ListNode ln = new ListNode(nums.get(i).get(0), 0, i);
			queue.add(ln);
			max = Math.max(max, ln.getValue());
		}
		
		while(queue.size() == nums.size()) {
			ListNode ln = queue.poll();
			int min = ln.getValue();
			int r = max - min;
			if(range > r) {
				range = Math.min(range, r);
				start = min;
				end = max;
			}
			
			if(ln.listIndex < nums.get(ln.rowIndex).size() - 1) {
				ln.listIndex++;
				int newValue = nums.get(ln.rowIndex).get(ln.listIndex);
				ln.setValue(newValue);
				if(max < newValue) {
					max = ln.getValue();
				}
				queue.add(ln);
			}
		}
		
		System.out.println(start + " : " + end);
	}
	
	
}

class ListNode {
	private int value;
	int listIndex;
	int rowIndex;
	public ListNode(int value, int listIndex, int rowIndex) {
		super();
		this.value = value;
		this.listIndex = listIndex;
		this.rowIndex = rowIndex;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getListIndex() {
		return listIndex;
	}
	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	@Override
	public String toString() {
		return "ListNode [value=" + value + ", listIndex=" + listIndex + ", rowIndex=" + rowIndex + "]";
	}
	
	
}
