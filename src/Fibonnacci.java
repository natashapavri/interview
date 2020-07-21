
public class Fibonnacci {

	public static void main(String[] args) {
		int n = 5;
		if(n<2) System.out.println(n);
		int n0 = 0;
		int n1 = 1;
		int n2 = 0;
		for(int i=2; i<=n; i++) {
			n2 = n1 + n0;
			n0 = n1;
			n1 = n2;
		}
		System.out.println(n2);
	}
}
