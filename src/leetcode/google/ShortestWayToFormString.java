package leetcode.google;

public class ShortestWayToFormString {

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		
		int count = findSubsequences(source, target);
		
		System.out.println(count);
		
	}

	private static int findSubsequences(String source, String target) {
		String remaining = target;
		int count = 0;
		while(remaining.length() > 0) {
			StringBuilder sb = new StringBuilder();
			int i = 0, j = 0;
			
			while(i < source.length() && j < target.length()) {
				if(source.charAt(i++) == remaining.charAt(j)) {
					sb.append(target.charAt(j++));
				} 
			}
			if(sb.length() == 0) {
				return -1;
			} else {
				count++;
			}
			remaining = remaining.substring(sb.length());
		}
		
		return count;
	}
}
