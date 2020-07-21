
public class Brackets {

	public static void main(String[] args) {
		String [] examples = {"()()()","(()))","((())"};
		for(String example : examples) {
			if(checkSanity(example)) {
				System.out.println(example + " is valid");
			} else {
				System.out.println(example + " is not valid");
			}
		}
	}

	private static boolean checkSanity(String example) {
		char[] chars = example.toCharArray();
		int open = 0;
		for(char c: chars) {
			if('(' == c) {
				open++;
			} else {
				open--;
			}
		}
		return (open == 0);
	}
	
	
}
