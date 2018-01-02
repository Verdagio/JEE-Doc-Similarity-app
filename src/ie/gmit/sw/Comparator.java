package ie.gmit.sw;

import java.util.List;
import java.util.Map;

/* Comparator - Defines a role which a class can play
 * In this case the class implementing this interface could
 * compare 2 lists against one another, and show the similarity
 * between them
 */
public interface Comparator {
	
	public float compare(List<Integer>a, List<Integer>b); 
	public Map<Integer, String> getSimilarity();
	
}
