package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class Processor {

	private File file;
	private List<Integer> shingles;

	public Processor(String filename) {
		this.file = new File(filename);
		shingles = new LinkedList<>();
	}// constructor

	/*
	 * ReadFile read in a file and add shingles to a list
	 */
	public List<Integer> readFile() throws Exception {
		String shingle = "";
		int i = 0;
		// create hashes
		// int [][] hashes = new int[key][2];

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			for (String word : words){
				shingle += word + " ";
				i++;
				if(i == 3) {
					shingles.add(shingle.hashCode());
					shingle = "";
					i = 0;
				}// if			
			}// for each word in the line
		} // while were reading the file

		return this.shingles;
	}// read the file

}//class
