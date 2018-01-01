package ie.gmit.sw;

import java.util.LinkedList;
import java.util.List;

public class Runner {
 
	public static void main(String[] args) {
		
		ListHandlerImpl lh = new ListHandlerImpl();
				
		List<Integer> c = new LinkedList<>();
		

		Processor p = new Processor("wap.txt");
		Processor p1 = new Processor("wap2.txt");
		List<Integer> a = new LinkedList<>();
		
		try {
			a = p.readFile();
			c = p1.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lh.compare(a, c) + "%");
		
		
	}//main

}// class
