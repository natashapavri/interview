
public class SortCharactersOfString {

	public static void main(String[] args) {
		String str = "helloworld";
		StringBuffer output = new StringBuffer();
		
		int[] letters = new int[26];
		
		for(int i = 0; i<str.length(); i++) {
			char x = str.charAt(i);
			letters[x-'a']++;
		}
		
		for(int i=0;i<letters.length;i++) {
			System.out.println(letters[i]);
		}
		
		for(int i = 0; i<26; i++) {
			for(int j = 0; j < letters[i]; j++) {
				output.append((char)(i+'a'));
			}
		}
		System.out.println(output.toString());
	}
}
