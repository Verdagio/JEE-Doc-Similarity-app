package ie.gmit.sw;

import java.util.LinkedList;
import java.util.List;

public class Runner {
 
	public static void main(String[] args) {
		
		Worker w = new Worker("hp2.txt");
		new Thread(w).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(w.getSimilarity());
		System.out.println(w.showPhrases());
	}//main

}// class
