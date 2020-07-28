package string;

public class StringSplosion {

	public static void main(String[] args) {
		String str = "Code";
		String result = stringSplosion(str);
		System.out.println(result);
	}

	public static String stringSplosion(String str) {
		String result = new String();
		for (int i = 0; i < str.length(); i++) {
			result = result + str.substring(0, i + 1);
		}
		return result;
	}
}
