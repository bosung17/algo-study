import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		
		set.add("a");
		set.add("z");
		set.add("c");
		set.add("b");
		set.add("p");
		set.add("d");
		set.add("e");
		
		set.forEach(System.out::println);
		System.out.println("----------------------------");
		
		set.add("r");
		set.add("o");
		set.add("y");
		
		set.forEach(System.out::println);
	}
}