package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileParser {

	private File file;
//	private InputStream is;
	private List<Integer> shingles;
	private static Map<Integer, String> hashTable;

	public FileParser(String filename) {
		this.file = new File(filename);
		this.shingles = new LinkedList<Integer>();
		FileParser.hashTable = new HashMap<Integer, String>();
	}// constructor
	
	// parse whatever is in the buffered reader and return a list of shingles
	public List<Integer> parse(BufferedReader br) throws Exception{
		String shingle = "";
		int i = 0;
		String line = null;

		while ((line = br.readLine()) != null) { // read in each line while its not null
			String[] words = line.split(" "); // put each word into a string array
			for (String word : words) { // for each word in the array
				i++;
				if (i != 3) { // if i isn't 3 append the shingle with the word followed by a space
					shingle += word + " ";
				} else if (i == 3) { // otherwise
					shingle += word; // append the shingle with just the word
					hashTable.put(shingle.hashCode(), shingle); // add the hashcode & the shingle into the hashTable
					shingles.add(shingle.hashCode()); // add the hashcode to a list of hashcodes
					shingle = ""; // set the shingle to nothing
					i = 0; // reset i
				} // if
			} // for each word in the line
		} // while were reading the file
		System.out.println(file.getName() + " has been shingled...");
		return this.shingles;
	}//parse
	
	
	// Read in an input stream and return shingles list
	public List<Integer> readInputStream(InputStream is) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(is)); // read the file as an input stream
		System.out.println("Using input stream reader");

		return parse(br);// parse the buffered reader and return the result of that
	}// read the file
	
	//ReadFile read in a file and add shingles to a list
	public List<Integer> readFile() throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(file)); // read the file passed into our constructor
		System.out.println("using file reader");

		return parse(br);// parse the buffered reader and return the result of that
	}// read the file

	/*
	 * Lookup Hash Table will allow us to use a hashcode to source the original
	 * string which it represents.
	 */
	public static String lookupHashTable(int findMe) {
		String res = null;
		res = hashTable.get(findMe);
		return res;
	}

	public String getFileName() {
		return this.file.getName();
	}

	public void setFileName(String fileName) {
		this.file = new File(fileName);
	}

	public Map<Integer, String> getHashTable() {
		return hashTable;
	}

}// class
