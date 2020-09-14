package google;

public class ShortestWayFromSourceToTarget {

	public static void main(String[] args) {
		String source = "bxdisnclwdrpcqamhqqvudgtdbsdikhzzbnlgzlspozvhdkunxkpevnqvyrfowanagolpwvezuvnhgxvjopcvrkdaippmwgkofbo";
		String target = "ntzebqmlrzxissncdlvcxbojgbnnphtfdunjpzroegfdvieaajafjkidpxbrgsjpgmalekhjckwgygfz";
		int count = shortestWay(source, target);
		System.out.println(count);
	}

	private static int shortestWay(String source, String target) {

		if (source.equals("") || source == null || target.equals("") || target == null) {
			return -1;
		}

		for (char c : target.toCharArray()) {
			if (!source.contains(c + "")) {
				return -1;
			}
		}

		int count = findShortestWay(source, target);
		return count;
	}

	private static int findShortestWay(String source, String target) {
		int count = 1;
		String temp = new String(source);
		for (int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			if (temp.indexOf(c) != -1) {
				temp = temp.substring(temp.indexOf(c) + 1);
			} else if (source.indexOf(c) != -1) {
				count++;
				temp = source.substring(source.indexOf(c) + 1);
			} else {
				return -1;
			}
		}

		return count;
	}
}
