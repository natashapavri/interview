package string;

public class LicenseKey {

	public static void main(String[] args) {
		String key = "2-5g-3-J";
		int k = 2;

		key = key.replaceAll("-", "");

		StringBuilder sb = new StringBuilder();

		for (int i = key.length() - 1; i >= 0;) {
			char[] licensePart = new char[k + 1];
			for (int j = k; j > 0; j--) {
				if (i >= 0) {
					licensePart[j] = key.charAt(i--);
				}
			}
			String str = new String(licensePart);
			str = str.trim();
			str = "-" + str;
			sb.insert(0, str.toUpperCase());
		}

		System.out.println(sb.substring(1).toString());
	}

}
