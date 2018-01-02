package ie.gmit.sw;

import java.util.LinkedList;
import java.util.List;

public class Runner {
 
	public static void main(String[] args) {
		
		ComparatorService cs = new ComparatorService();
				
		List<Integer> c = new LinkedList<>();
		

		Processor p = new Processor("hp2.txt");
		Processor p1 = new Processor("hp4.txt");
		List<Integer> a = new LinkedList<>();
		
		try {
			a = p.readFile();
			c = p1.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cs.compare(a, c) + "%");
		System.out.println(cs.getSimilarity());
		
	}//main

}// class
