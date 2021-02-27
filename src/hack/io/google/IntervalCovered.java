package hack.io.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IntervalCovered {

	public static void main(String[] args) {
		List<Coordinate> points = new ArrayList<Coordinate>();
		points.add(new Coordinate(2, 3));
		points.add(new Coordinate(3, 4));
		points.add(new Coordinate(5, 6));
		points.add(new Coordinate(6, 7));
		
		Coordinate merge = new Coordinate(3, 7);
		
		Stack<Coordinate> stack = new Stack<>();
		stack.push(points.get(0));
		
		for(int i = 1; i < points.size(); i++) {
			Coordinate current = points.get(i);
			Coordinate previous = stack.peek();
			if(current.x <= previous.y) {
				previous.y = current.y;
				stack.pop();
				stack.push(previous);
			} else {
				stack.push(current);
			}
		}
		
		while(!stack.isEmpty()) {
			Coordinate p = stack.pop();
			if(merge.x >= p.x && merge.y <= p.y) {
				System.out.println("Covered interval");
				return;
			}
		}
		System.out.println("Not covered interval");
	}
}

class Coordinate {
	int x;
	int y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

}
