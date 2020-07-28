package arrays;

public class SwapIntegers {

	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		a=a+b;
		b=a-b;
		a=a-b;
				
		System.out.println(a);
		System.out.println(b);
		
		a = 5;
		b = 6;
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a);
		System.out.println(b);
	}
}
