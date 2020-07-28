package string;
import java.util.HashMap;
import java.util.Map;

public class StringFrequencyCompare {

	public static void main(String[] args) {
		String a = "abcd,aabc,bd";
		String b = "aaa,aa";
		
		String[] arrA = a.split(",");
		String[] arrB = b.split(",");
		
		Map<String, Integer> freqB = new HashMap<>();
		Map<String, Integer> freqA = new HashMap<>();
		
		for(String str : arrB) {
			int count = 1;
			char[] ch = str.toCharArray();
			for(int i = 1; i<ch.length; i++) {
				if(ch[i] == ch[0]) {
					count++;
				}
			}
			freqB.put(str, count);
		}
		for(String str : arrA) {
			int count = 1;
			char[] ch = str.toCharArray();
			for(int i = 1; i<ch.length; i++) {
				if(ch[i] == ch[0]) {
					count++;
				}
			}
			freqA.put(str, count);
		}
		int[] counts = new int[Math.min(arrA.length, arrB.length)];
		int i =0;
		for(String bstr : freqB.keySet()) {
			int countB = freqB.get(bstr);
			for(String astr : freqA.keySet()) {
				int countA = freqA.get(astr);
				if(countA<countB) {
					counts[i]++;
				}
			}
			i++;
		}
		
		for(int k : counts) {
			System.out.println(k);
		}
	}
}
