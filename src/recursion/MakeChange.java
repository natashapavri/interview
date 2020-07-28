package recursion;
public class MakeChange {

	public static void main(String[] args) {
		int change = 50;
		int[] coins = {25,10,5,1};
		int numberOfCoins = 0;
		if(change == 0) System.out.println(numberOfCoins);
		if(change < 0) throw new IllegalArgumentException();
		
		while(change != 0) {
			for(int i =0 ; i< coins.length; i++) {
				if(coins[i] <= change) {
					change -= coins[i];
					numberOfCoins++;
					break;
				}
			}
		}
		System.out.println(numberOfCoins);
	}
}
