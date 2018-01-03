package ie.gmit.sw;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;
import com.db4o.ta.TransparentPersistenceSupport;

import xtea_db4o.XTEA;
import xtea_db4o.XTeaEncryptionStorage;

import java.lang.System.*;

public class DBRunner {
	private ObjectContainer db = null;
	private List<Book> books = new LinkedList<Book>();
	
	public DBRunner() {
		
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().add(new TransparentPersistenceSupport());
		config.common().updateDepth(7);	// propagate updates
		
		// using xtea library for encryption
		config.file().storage(new XTeaEncryptionStorage("password", XTEA.ITERATIONS64));
		
		db = Db4oEmbedded.openFile(config, "books.data");
		
		addBooksToDB();
		showAllBooks();
		
	}// runner
	
	private void addBooksToDB() {
		for(Book b : books) {
			db.store(b); // Add book objects to the database
		}//for each book in books
		db.commit(); // commit the transaction
	}// add to db
	
	private void showAllBooks() {
		ObjectSet<Book> books = db.query(Book.class);
		for(Book b : books) {
			System.out.println("[Book] " + b.getName() + "\n DB ObjID: " + db.ext().getID(b));
			db.commit();	
		}// for each book in books
	}// show all books
		
	//	db4o's S.O.D.A. (Simple Object Data Access) query mechanism is a perfect example of API layering. 
	//	S.O.D.A. is db4o's internal query system, QBE and Native Queries are translated into S.O.D.A. 
	//	So if  the other queries are being translated into S.O.D.A. we may as well just use it for all the biscuits
	private void getBook(Book b) {
		Query query = db.query();
		query.constrain(Book.class);
		query.descend("bookId").constrain(b.getBookId());
		ObjectSet<Book> result = query.execute();
		if(result.hasNext()) {
			System.out.println("[getBookID] found " + b.getName());
		} else {
			System.out.println("[Error] " + b.getBookId() + " not in Database");
		}
		
	}// Get book SODA query
}
