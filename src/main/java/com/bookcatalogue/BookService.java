package com.bookcatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.bookcatalogue.model.Book;

/**
 *
 * @author x17135486
 */
public class BookService {
    
    public static List<Book> bookList = initBooks();;
    private static Logger LOGGER = Logger.getLogger(BookService.class.getSimpleName());
    
    public List<Book> getAllBooks(){
    	LOGGER.info("entering getAllBooks()...");        
        LOGGER.info("returning: " + bookList);
        return bookList;
    }
    
    private static List<Book> initBooks() {
    	bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "The Hobbit", "Wesley Snipes", "The Book Co."));
        bookList.add(new Book(2, "The Twits", "Roald Dahl", "Pub One"));
        bookList.add(new Book(3, "A Scanner Darkly", "P.K.D", "Self"));
        bookList.add(new Book(4, "Clothing Store Entity", "Team", "123 Books"));
        bookList.add(new Book(5, "Best Book", "B.O.O.K", "MNC"));
        return bookList;
	}

	public Book getBook(int id){
    	LOGGER.info("entering getBook()...ith id: " + id);
    	try {
    		return bookList.get(id - 1);
		} catch (Exception e) {
			LOGGER.warning("** no book found **");
			return null;
		}        
    }

	public Book deleteBook(int id) {
		Book deletedBook = bookList.get(id - 1);
		bookList.remove(id - 1);
		return deletedBook;
	}

	public static void addToBookList(Book createBook) {
		createBook.setId(bookList.size() + 1);
		bookList.add(createBook);
	}    
}
