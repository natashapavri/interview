import java.awt.List;
import java.sql.Array;
import java.util.ArrayList;

public class Test {
public static void main(String[] args) {
	
	print();
	String me = "heloo";
	me.concat("world");
	me+="!";
	System.out.println(me);
	float n = 0b1010;
	List list = new ArrayList<>();
	list.add("");
	list.add(0);
	
}
static void print() {
	try {
		System.out.println("Helo");
	} finally {
		System.out.println("!");
	}
}
}
