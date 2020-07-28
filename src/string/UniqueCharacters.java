package string;

public class UniqueCharacters {

	public static void main(String[] args) {
		String strNotUnique = "hello";
		String strUnique = "world";
		
		System.out.println(isUnique(strNotUnique));
		System.out.println(isUnique(strUnique));
	}

	private static boolean isUnique(String str) {
		int[] letters = new int[256];
		for(char c: str.toCharArray()) {
			letters[c]++;
		}
		for(int i : letters) {
			if(i>1) return false;
		}
		return true;
	}
}
