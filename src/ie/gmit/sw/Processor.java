package ie.gmit.sw;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class Processor {

	private String fileName;
	private boolean inProgress;
	private List<Worker> q;
	InputStream is;

	public Processor(String fileName, InputStream is) {
		this.is = is;
		this.fileName = fileName;
		this.q = new LinkedList<Worker>();
		this.inProgress = false;
	}

	public String runner() {
		float percentage = 0;
		String phrases = null;
		//Worker w =;
		q.add(new Worker("lib/wap.txt", is));

		do {
			if (!inProgress) {
				inProgress = true;
				Worker w = (Worker) q.get(0);
				new Thread(w).start();
				System.out.println("Worker invoked... please wait a few seconds");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				percentage = w.getSimilarity();
				phrases = w.showPhrases();
				q.remove(0);
				System.out.println("Queue empty: " + q.isEmpty());
				inProgress = false;
			}
		} while (inProgress);

		return percentage + "%\n" + phrases;
	}

}
