package ie.gmit.sw;

import java.util.LinkedList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		List<Integer> a = new LinkedList<Integer>();
		List<Integer> b = new LinkedList<Integer>();
		List<String> c = new LinkedList<String>();
		List<String> d = new LinkedList<String>();
		
		c.add("Hello world");
		c.add("i love coffee");
		c.add("java is fun");
		d.add("coffee is love");
		d.add("doggos are fren");
		d.add("Hello world");
		
		ListHandlerImpl lh = new ListHandlerImpl();
		
		a = lh.convert(c);
		b = lh.convert(d);
		
		System.out.println((lh.compare(a, b) * 100) + "%" );
		
		
		
	}

}
