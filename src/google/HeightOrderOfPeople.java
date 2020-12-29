package google;

import java.util.Arrays;

public class HeightOrderOfPeople {

	public static void main(String[] args) {
		int[] heights = { 5, 3, 2, 6, 1, 4 };
		int[] inFront = { 0, 1, 2, 0, 3, 2 };

		Person[] people = new Person[heights.length];

		for (int i = 0; i < heights.length; i++) {
			Person p = new Person(heights[i], inFront[i]);
			people[i] = p;
		}

		Arrays.sort(people);
		
		Person[] result = new Person[heights.length];
		
		for(Person p : people) {
			int count = 0;
			for(int i = 0; i < heights.length; i++) {
				if(count == p.getInfront()) {
					while(result[i] != null && i < heights.length) {
						i++;
					}
					result[i] = p;
					break;
				}
				if(result[i] == null) count++;
			}
		}
		
		for(Person p : result) {
			System.out.print(p.getHeight() + " ");
		}
	}
}

/**
 * @author Natasha
 *
 */
class Person implements Comparable<Person> {
	int height;
	int infront;

	public Person(int height, int infront) {
		super();
		this.height = height;
		this.infront = infront;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getInfront() {
		return infront;
	}

	public void setInfront(int infront) {
		this.infront = infront;
	}

	@Override
	public int compareTo(Person o) {
		return this.getHeight() - o.getHeight();
	}

	@Override
	public String toString() {
		return "Person [height=" + height + ", infront=" + infront + "]";
	}
	
	

}
