package google;

public class StudentRecord {

	public static void main(String[] args) {
		int rs = checkRecord(4);
		System.out.println(rs);
	}

	static long oneAwith2L = 0;
	static long oneAwith1L = 0;
	static long oneAwith0L = 0;
	static long noAwith2L = 0;
	static long noAwith1L = 0;
	static long noAwith0L = 0;
	
	private static int checkRecord(int n) {
		
		if(n == 1) {
			return 3;
		}
		check(n);
		return (int) ((oneAwith2L + oneAwith1L + oneAwith0L + noAwith2L + noAwith1L + noAwith0L) % (1e9 + 7)); 
	}

	private static void check(int n) {
		
		if(n == 2) {
			oneAwith2L = 0;
			oneAwith1L = 1;
			oneAwith0L = 3;
			noAwith2L = 1;
			noAwith1L = 1;
			noAwith0L = 2;
			
			return;
		}
		
		check(n-1);
		
		long currOneAWith2L = oneAwith1L;
		long currOneAWith1L = oneAwith0L;
		long currOneAWith0L = (long) ((oneAwith2L + oneAwith1L + oneAwith0L + noAwith2L + noAwith1L + noAwith0L) % (1e9 + 7));
		long currNoAWith2L = noAwith1L;
		long currNoAWith1L = noAwith0L;
		long currNoAWith0L = (long) ((noAwith2L + noAwith1L + noAwith0L) % (1e9 + 7));
		
		oneAwith2L = currOneAWith2L;
		oneAwith1L = currOneAWith1L;
		oneAwith0L = currOneAWith0L;
		noAwith2L = currNoAWith2L;
		noAwith1L = currNoAWith1L;
		noAwith0L = currNoAWith0L;
	}
}
