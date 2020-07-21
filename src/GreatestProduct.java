
public class GreatestProduct {

	long findGreatestProduct(long[] numbers) {
		long maxProduct = 1;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1 + 1; j < numbers.length; j++) {
				long product = numbers[i] * numbers[j];
				if (product > maxProduct)
					maxProduct = product;
			}
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		long[] numbers = { 10, 2, 2, 4, 30, 35 };
		GreatestProduct obj = new GreatestProduct();
		System.out.println("max product: " + obj.findGreatestProduct(numbers));
	}
}
