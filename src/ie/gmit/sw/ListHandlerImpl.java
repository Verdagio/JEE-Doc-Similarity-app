package ie.gmit.sw;

import java.util.LinkedList;
import java.util.List;

/* The Processor class is responsible for handling lists
 * It will compare 2 lists against each other
 * Convert string lists into hash code lists
 */
public class ListHandlerImpl implements ListHandler{
	
	public ListHandlerImpl() {}// constructor
	
	/*
	 * (non-Javadoc)
	 * @see ie.gmit.sw.Comparator#compare(java.util.List, java.util.List)
	 * Compare 2 list objects of integers together and return a float similarity  
	 */
	public float compare(List<Integer> a, List<Integer> b) {
		float similarity = 0.0f;
		
		for(int i = 0; i < b.size(); i++) {	// O(N)
					
			if(b.contains(a.get(i))) {
				similarity++;
			}//if b contains a
		
		}// for each element in b 
		similarity = similarity / b.size(); //get a percentage
		
		return similarity * 100;
	}// compare method
	
	
	/*
	 * (non-Javadoc)
	 * @see ie.gmit.sw.ListHandler#convert(java.util.List)
	 * Convert a list of strings into a list of int hashCodes.
	 * return the new list.
	 */
	public List<Integer> convert(List<String>a){
		List<Integer> b = new LinkedList<>();
		
		for(int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).hashCode());
			b.add(a.get(i).hashCode());
			System.out.println(b.get(i));
		}
		
		return b; 
	}
	
}
