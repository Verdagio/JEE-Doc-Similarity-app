package ie.gmit.sw;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class Processor {

	private Queue<Worker> q;
	private InputStream is;
	private InputStream db;
	
	public Processor(InputStream is, InputStream db) {
		this.is = is;
		this.db = db;
		q = new LinkedList<Worker>();
	}

	public String runner() {
	
		q.add(new Worker(is, db));
		
		Worker w = (Worker) q.peek();
		new Thread(w).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res = w.getSimilarity() + "%<br>" + w.showPhrases();
		
		q.poll();
		return res;
		
		
	}


}
