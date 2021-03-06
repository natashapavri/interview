package google;

public class BookAllocation {

	public static void main(String[] args) {
		int[] books = { 12, 34, 67, 90 };
		int students = 2;

		int minPages = findMinPages(books, students);
		
		System.out.println(minPages);

	}

	private static int findMinPages(int[] books, int students) {
		int sum = 0;
		int l = Integer.MAX_VALUE;
		for (int book : books) {
			sum += book;
			l = Math.min(l, book); 
		}

		int left = l;
		int right = sum;

		int minPages = Integer.MAX_VALUE;
		
		while (right >= left) {
			int mid = left + (right - left) / 2;
			if(isPossible(books, students, mid)) {
				right = mid - 1;
				minPages = Math.min(minPages, mid);
			} else {
				left = mid + 1;
			}
		}
		
		return minPages;
	}

	private static boolean isPossible(int[] books, int students, int mid) {
		
		int currentSum = 0;
		int maxSum = mid;
		
		int studentsRequired = 1;
		
		for(int i = 0;i<books.length;i++) {
			if(books[i] > maxSum) {
				return false;
			}
			if(books[i] + currentSum > maxSum) {
				studentsRequired++;
				currentSum = 0;
				if(studentsRequired > students) {
					return false;
				}
			}
			currentSum+= books[i];
		}
		
		return true;
	}
}
