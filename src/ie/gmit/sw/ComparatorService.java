package ie.gmit.sw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* The Processor class is responsible for handling lists
 * It will compare 2 lists against each other
 * Convert string lists into hash code lists
 */
public class ComparatorService implements Comparator{
	
	private Map<Integer, String> similarShingles;
	
	public ComparatorService() {
		similarShingles = new HashMap<>();
	}// constructor
	
	/*
	 * (non-Javadoc)
	 * @see ie.gmit.sw.Comparator#compare(java.util.List, java.util.List)
	 * Compare 2 list objects of integers together and return a float similarity  
	 * A being the primary comparator vs B the list we want to compare against A
	 */
	public float compare(List<Integer> a, List<Integer> b) {
		System.out.println("Running comparison...");
		float similarity = 0.0f;
		int size = 0;
		
		// a little bit of error handling to prevent out of bounds issues
		// set the loop size the the smaller of the 2 lists.
		if(b.size() < a.size()) {
			size = b.size();
		} else {
			size = a.size();
		}// if else 		
		// we don't really need to compare the whole document if its over a certain size
		if (size > 1000) {
			size = 1000; // 1000 shingles should be fine. (3000 words)
		}// if
		
		for(int i = 0; i < size; i++) {	// O(N) as the size grows so does the time of completion	
			if(a.contains(b.get(i))) {
				similarShingles.put(b.get(i), Processor.lookupHashTable(b.get(i)));
				similarity++; // similarity goes up if a contains b
			}//if b contains a		
		}// for each element in the list
		similarity = similarity / size * 100; //get a percentage
		return similarity;
	}// compare method
	
	/*
	 * (non-Javadoc)
	 * @see ie.gmit.sw.Comparator#getSimilarity()
	 * getSimilarity will return a HashMap that contains the similar shingles
	 */
	public Map<Integer, String> getSimilarity() {
		// TODO Auto-generated method stub
		return similarShingles;
	}
	
}
