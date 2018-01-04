package ie.gmit.sw;

public class Worker implements Runnable {

	private Book bk;
	private FileParser fp;
	private ComparatorService cs;
	private DataStore ds;
	private float similarity;
	
	public Worker(String fileName) {
		this.ds = new DataStore();
		this.fp = new FileParser(fileName);
		this.cs = new ComparatorService();
		this.bk = new Book();
	}
	
	public void run() {
		Book dbBook = ds.getBook();
		
		try {	// try to populate a book object
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
	}
	public float getSimilarity() {
		return this.similarity;
	}
	
	public String showPhrases() {
		return cs.getSimilarity().toString();
	}

}
