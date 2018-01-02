package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Processor {

	private File file;
	private List<Integer> shingles;
	private static Map<Integer, String> hashTable;

	public Processor(String filename) {
		this.file = new File(filename);
		this.shingles = new LinkedList<>();
		this.hashTable = new HashMap<>();
	}// constructor

	/*
	 * ReadFile read in a file and add shingles to a list
	 * 
	 */
	public List<Integer> readFile() throws Exception {
		String shingle = "";
		int i = 0;

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			for (String word : words) {
				shingle += word + " ";
				i++;
				if(i == 3) {			
					hashTable.put(shingle.hashCode(), shingle);
					shingles.add(shingle.hashCode());
					shingle = "";
					i = 0;
				}// if			
			}// for each word in the line
		} // while were reading the file
		System.out.println(file.getName() + " has been shingled...");
		return this.shingles;
	}// read the file
	
	/*
	 * Lookup Hash Table will allow us to use a hashcode to source
	 * the original string which it represents.
	 */
	public static String lookupHashTable(int findMe) {
		String res = null;	
		res = hashTable.get(findMe);	
		return res;		
	}

}//class
