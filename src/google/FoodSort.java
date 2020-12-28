package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class FoodSort {

	public static void main(String[] args) {
		Fruit f1 = new Fruit("apple", 150);
		Fruit f2 = new Fruit("apple", 120);
		Fruit f3 = new Fruit("banana", 200);
		TreeMap<String, List<Integer>> fruitPriceMap = new TreeMap<>();
		fruitPriceMap.put(f1.getFruit(), new ArrayList<>());
		fruitPriceMap.get(f1.getFruit()).add(f1.getPrice());
		fruitPriceMap.get(f1.getFruit()).add(f2.getPrice());
		fruitPriceMap.put(f3.getFruit(), new ArrayList<>());
		fruitPriceMap.get(f3.getFruit()).add(f3.getPrice());
		
		for(String f : fruitPriceMap.keySet()) {
			int min = Collections.min(fruitPriceMap.get(f));
			int max = Collections.max(fruitPriceMap.get(f));
			double avg = fruitPriceMap.get(f).stream().mapToInt(a -> a).average().getAsDouble();
			System.out.println(f + " " + min + " " + max + " " + avg);
		}
	}
}

class Fruit {
	private String fruit;
	private int price;

	public Fruit(String fruit, int price) {
		super();
		this.fruit = fruit;
		this.price = price;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
