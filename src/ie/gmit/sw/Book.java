package ie.gmit.sw;

import java.util.List;
import java.util.Map;

/* Book Is an object class that stores relevant data
 * that is required for this project
 */
public class Book {

	private String name;
	private List<Integer> shingles;
	private Map<Integer, String> hashData;
	private int id;

	public Book() {
		super();
	}

	public Book(String name, List<Integer> shingles, Map<Integer, String> hashData) {
		super();
		this.name = name;
		this.shingles = shingles;
		this.hashData = hashData;
	}

	public Book(String name) {
		super();
		this.name = name;
	}

	// getters & setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getShingleData() {
		return shingles;
	}

	public void setShingleData(List<Integer> shingleData) {
		this.shingles = shingleData;
	}

	public Map<Integer, String> getHashData() {
		return hashData;
	}

	public void setHashData(Map<Integer, String> hashData) {
		this.hashData = hashData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}// class
