package leetcode.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallerNumbersToRight {

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };
		List<Integer> result = new ArrayList<>();
		result.add(0);
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		for(int i = nums.length - 2; i >= 0; i--) {
			result.add(root.insert(nums[i]));
		}
		Collections.reverse(result);
		
		for(int i : result) {
			System.out.print(i + "-->");
		}
	}
}
class TreeNode {
	private int val;
	private TreeNode left;
	private TreeNode right;
	private int total;
	int cnt;
	
	public TreeNode(int val) {
		this.val = val;
		this.cnt = 1;
		this.total = 1;
	}
	
	public int insert(int val) {
		total++;
		if(val == this.val) {
			cnt++;
			return getLeftCount();
		}
		else if(val < this.val) {
			return insertLeft(val);
		} else {
			return this.getLeftCount() + this.cnt + insertRight(val);
		}
	}

	private int getLeftCount() {
		if(this.left != null)
			return this.left.total;
		else
			return 0;
	}

	private int insertRight(int val) {
		if(this.right == null) {
			TreeNode right = new TreeNode(val);
			this.right = right;
			return 0;
		} else {
			return this.right.insert(val);
		}
	}

	private int insertLeft(int val) {
		if(this.left == null) {
			TreeNode left = new TreeNode(val);
			this.left = left;
			return 0;
		} else {
			return this.left.insert(val);
		}
	}
}
