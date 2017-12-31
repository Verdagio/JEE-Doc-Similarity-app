package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Processor {
	
	private File file;
	
	public Processor(String filename) {
		this.file = new File(filename);
	}// constructor
	
	public List<String> readFile() throws Exception{
		
		// create hashes
		//int [][] hashes = new int[key][2];
		
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		
		while((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			String shingle;
		}// while were reading the file 
		
		
		return null;
	}// read the file 
	
}
