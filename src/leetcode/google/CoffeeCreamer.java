package leetcode.google;

import java.util.TreeMap;

public class CoffeeCreamer {

	//Similar to https://leetcode.com/problems/maximum-number-of-eaten-apples/solution/
	/**
	 * The office manager of a healthcare billing company has been charged with
	 * eliminating food waste in the office lounge. The lounge has packets of
	 * coffee creamer, each with an expiry date. The creamer must be used no
	 * later than that day. The manager also has the option to order additional
	 * coffee creamer from a grocery store, each with varying expiry dates.
	 * Given a fixed daily demand for creamer, find the maximum amount of
	 * additional creamer the manager can order without waste. Example loungeon
	 * Hand = [0, 2, 2] supplier = [2,0,0] demand = 2• The lounge has 3 units on
	 * hand expiring in [0,2,2]days, respectively• The store has an additional 3
	 * units available, expiring in 2,0,0 days• Employees use at most 2 units of
	 * coffee creamer per day.
	 * 
	 * The manager can order a maximum of 2 units the one expiring in 2 days
	 * (expiry[0], and one in 0 days (eg. expiry[1]). The creamer can then
	 * beused as follows: Day 0 onHand[0] and supplier[1] Day 1: on Hand[1) and
	 * supplier[0] Day 2 on Hand[2]
	 * 
	 * return maximum units of creamer the manager can order without waste.
	 * 
	 * Time complexity = O(maxExpiryDate log(maxExpiryDate))
	 * Space complexity = O(H) + O(S) where H is the number of creamers on hand and S is creamers with supplier
	 */

	public static void main(String[] args) {
		int[] onHand = { 1, 1, 1 };
		int[] onHandExpiry = { 0, 2, 2 };
		int[] supplier = { 1, 1, 1 };
		int[] supplierExpiry = { 2, 0, 0 };
		int demand = 2;
		
		TreeMap<Integer, Integer> onHandExpiryMap = new TreeMap<>();
		TreeMap<Integer, Integer> supplierExpiryMap = new TreeMap<>();
		
		int count = 0;
		
		for(int i = 0; i < onHand.length || !onHandExpiryMap.isEmpty() || !supplierExpiryMap.isEmpty(); i++) {
			if(i < onHand.length) {
				int currentExpiryOnHand = i + onHandExpiry[i];
				onHandExpiryMap.put(currentExpiryOnHand, onHandExpiryMap.getOrDefault(currentExpiryOnHand, 0) + onHand[i]);
			}
			if(i < supplier.length) {
				int currentExpirySupplier = i + supplierExpiry[i];
				supplierExpiryMap.put(currentExpirySupplier, supplierExpiryMap.getOrDefault(currentExpirySupplier, 0) + supplier[i]);
			}
			while(!onHandExpiryMap.isEmpty() && onHandExpiryMap.firstKey() < i) {
				onHandExpiryMap.remove(onHandExpiryMap.firstKey());
			}
			while(!supplierExpiryMap.isEmpty() && supplierExpiryMap.firstKey() < i) {
				supplierExpiryMap.remove(supplierExpiryMap.firstKey());
			}
			int k = demand;
			while(!onHandExpiryMap.isEmpty() && k-- > 0) {
				int key = onHandExpiryMap.firstKey();
				onHandExpiryMap.put(key, onHandExpiryMap.get(key) - 1);
				if(onHandExpiryMap.get(key) == 0) {
					onHandExpiryMap.remove(key);
				}
			}
			while(k-- > 0 && !supplierExpiryMap.isEmpty()) {
				count++;
				int key = supplierExpiryMap.firstKey();
				supplierExpiryMap.put(key, supplierExpiryMap.get(key) - 1);
				if(supplierExpiryMap.get(key) == 0) {
					supplierExpiryMap.remove(key);
				}
			}
		}
		
		System.out.println(count);
	}
}
