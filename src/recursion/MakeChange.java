package recursion;
public class MakeChange {

	public static void main(String[] args) {
		int change = 50;
		int[] coins = {25,10,5,1};
		
		int[] cache = new int[change + 1];
		
		for(int i = 1; i <= change; i++) {
			int minCoins = Integer.MAX_VALUE;
			
			for(int coin : coins) {
				if(i - coin >= 0) {
					int currCoins = cache[i - coin] + 1;
					if(minCoins > currCoins) {
						minCoins = currCoins;
					}
				}
			}
			cache[i] = minCoins;
		}
		
		System.out.println(cache[change]);
	}
}
