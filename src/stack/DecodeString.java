package stack;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String input1 = "3[a]2[bc]";
		String input2 = "3[a2[c]]";
		String input3 = "abc3[cd]xyz";
		String input4 = "2[abc]3[cd]ef";

		System.out.println(decode(input1));
		System.out.println(decode(input2));
		System.out.println(decode(input3));
		System.out.println(decode(input4));
	}

	private static String decode(String input) {
		Stack<StringBuilder> sbs = new Stack<>();
		Stack<Integer> times = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			if(Character.isDigit(input.charAt(i))) {
				int num = 0;
				int digit = input.charAt(i);
				while(input.charAt(i) != '[') {
					num = num * 10 + (digit - '0');
					i++;
				}
				times.push(num);
				sbs.push(new StringBuilder());
			}
			else if(input.charAt(i) == ']') {
				String str = sbs.pop().toString();
				int num = times.pop();
				while(num-- > 0) {
					if(sbs.isEmpty()) {
						StringBuilder sb = new StringBuilder();
						sb.append(str);
						sbs.push(sb);
					}else {
						sbs.peek().append(str);
					}
				}
			}
			else {
				if(sbs.isEmpty()) {
					StringBuilder sb = new StringBuilder();
					sb.append(input.charAt(i));
					sbs.push(sb);
				} else 
					sbs.peek().append(input.charAt(i));
			}
		}
		return sbs.peek().toString();
	}

}
