package ie.gmit.sw;

import java.io.InputStream;

/* The worker class is a runnable class with intent to replace
 * a typical runner class which would connect all the pieces 
 * of the puzzle together. The worker will do the grunt work 
 * for us by way of task delegation to the respective classes.
 */
public class Worker implements Runnable {

	private FileParser fp;
	private ComparatorService cs;
	private DataStore ds;
	private float similarity;
	private InputStream is;

	public Worker(String fileName, InputStream is) {
		this.ds = new DataStore();
		this.fp = new FileParser(fileName);
		this.cs = new ComparatorService();
		this.is = is;
	}// constructor
	
	public Worker(String fileName) {
		this.ds = new DataStore();
		this.fp = new FileParser(fileName);
		this.cs = new ComparatorService();
	}// constructor
	
	

	public void run() {

		Book dbBook = ds.getBook();
		Book bk = new Book();

		try { // try to populate a book object
			bk.setName(fp.getFileName());
			bk.setBookId(this.hashCode());
			bk.setShingleData(fp.readFile());
			bk.setHashData(fp.getHashTable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setSimilarity(cs.compare(dbBook.getShingleData(), bk.getShingleData()));
	}

	public void setSimilarity(float f) {
		this.similarity = f;
	}// set the similarity

	public float getSimilarity() {
		return this.similarity;
	}// return the similarity

	public String showPhrases() {
		return cs.getSimilarity().toString();
	}// delegate the task of retrieving the similar phrases

}// class
