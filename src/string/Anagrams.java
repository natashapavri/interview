package string;
import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {
		String str1 = "helloworld" ;
		String str2 = "aorldhello";
		
		System.out.println(isAnagram(str1, str2));
		System.out.println(isAnagram2(str1, str2));
	}

	private static boolean isAnagram2(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		int[] letters = new int[256];
		for(char c : str1.toCharArray()) {
			letters[c]++;
		}
		
		for(char c: str2.toCharArray()) {
			letters[c]--;
		}
		
		for(int i : letters) {
			if(i!=0) return false;
		}
		return true;
	}

	private static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		char[] str1Arr = str1.toLowerCase().toCharArray();
		char[] str2Arr = str2.toLowerCase().toCharArray();
		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);
		System.out.println(str1Arr);
		System.out.println(str2Arr);
		str1 = new String(str1Arr);
		str2 = new String(str2Arr);
		return str1.equals(str2);
	}
	
	
}
