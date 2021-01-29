package google;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 1, 3, 2, 4, 5 };

		int remainingGas = 0;
		int index = Integer.MAX_VALUE;
		for (int i = 0; i < gas.length; i++) {
			remainingGas += gas[i];
			if (remainingGas >= cost[i]) {
				index = Math.min(index, i);
				remainingGas -= cost[i];
			} else {
				index = Integer.MAX_VALUE;
				remainingGas-=gas[i];
			}
		}
		if (index == Integer.MAX_VALUE)
			index = -1;
		System.out.println(index);
	}
}
