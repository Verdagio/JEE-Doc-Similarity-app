package ie.gmit.sw;

import java.util.List;
import java.util.Map;

public class Book {
	
	private String name;
	private List<Integer> shingles;
	private Map<Integer, String> hashData;
	private int bookId;
	private List<String> data;				// TODO should this be used or not
	
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

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}//class
