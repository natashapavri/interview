package bit;

public class IntToBinary {

	public static void main(String[] args) {
		int x = 4;
		StringBuilder binary = new StringBuilder();

		for (int i = 31; i >= 0; i--) {
			if ((x & (1 << i)) != 0)
				binary.append("1");
			else
				binary.append("0");
		}

		System.out.println(binary.toString());
	}
}
