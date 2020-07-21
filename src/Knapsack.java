import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Knapsack {

	public static void main(String[] args) {
		Item i1 = new Item(14d, 20d);
		Item i2 = new Item(6d, 16d);
		Item i3 = new Item(10d, 8d);
		List<Item> items = Arrays.asList(i1, i2, i3);
		Collections.sort(items);
		Collections.reverse(items);
		for (int i = 0; i < items.size(); i++) {
			// System.out.println(items.get(i).getPrice() + "::" +
			// items.get(i).getWeight());
		}
		List<Item> packed = new ArrayList<>();
		double maxWeight = 19;
		for (Item i : items) {
			if (i.getWeight() <= maxWeight && maxWeight!=0) {
				packed.add(i);
				maxWeight -= i.getWeight();
			}
		}

		for (int i = 0; i < packed.size(); i++) {
			System.out.println(packed.get(i).getPrice() + "::" + packed.get(i).getWeight());
		}
	}
}

class Item implements Comparable<Item> {
	private Double weight;
	private Double price;
	private Double avgWeight;

	public Item(Double weight, Double price) {
		super();
		this.weight = weight;
		this.price = price;
		this.avgWeight = price/weight;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getAvgWeight() {
		return avgWeight;
	}

	public void setAvgWeight(Double avgWeight) {
		this.avgWeight = avgWeight;
	}

	@Override
	public int compareTo(Item o) {
		return this.getAvgWeight().compareTo(o.getAvgWeight());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

}