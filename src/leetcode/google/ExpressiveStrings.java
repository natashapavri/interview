package leetcode.google;

import java.util.ArrayList;
import java.util.List;

class ExpressiveStrings {
	
	public static void main(String[] args) {
		String S = "heeellooo";
		String[] words = {"hello", "hi", "helo"};
		int result = expressiveWords(S, words);
		System.out.println(result);
	}
    public static int expressiveWords(String S, String[] words) {
        
        CompressedString csInput = new CompressedString(S);
        
        int result = 0;
        for(String word : words) {
            CompressedString csWord = new CompressedString(word);
            if(csInput.getKey().equals(csWord.getKey())) {
            	boolean isValid = true;
                for(int i = 0; i < csInput.getKey().length(); i++) {
                    int inputCtr = csInput.getCounts().get(i);
                    int wordCtr = csWord.getCounts().get(i);
                    if(inputCtr < 3 && inputCtr != wordCtr || inputCtr < wordCtr) {
                    	isValid = false;
                        break;
                    }
                }
                if(isValid)
                	result++;
            }
        }
        return result;
    }
}
class CompressedString {
    String key;
    List<Integer> counts;
    
    public CompressedString(String s) {
        counts = new ArrayList<>();
        
        int prevIndex = 0;
        int count = 0;
        this.key = new String("");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(prevIndex) == s.charAt(i)) {
                count++;
            } else {
                key+=s.charAt(prevIndex)+"";
                counts.add(count);
                prevIndex = i;
                count = 1;
            }
        }
        counts.add(count);
        key+=s.charAt(prevIndex)+"";
    }
    
    public List<Integer> getCounts() {
        return counts;
    }
    
    public String getKey() {
        return key;
    }
}
