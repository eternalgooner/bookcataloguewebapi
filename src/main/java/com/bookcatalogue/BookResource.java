
package com.bookcatalogue;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.bookcatalogue.model.Book;
import com.bookcatalogue.responses.DeleteBookResponse;
import com.bookcatalogue.responses.BookNotFoundResponse;
import com.bookcatalogue.responses.CreateBookResponse;

/**
 *
 * @author x17135486
 */
@Path("/rest/")
public class BookResource {
	
	private static Logger LOGGER = Logger.getLogger(BookResource.class.getSimpleName());
    private BookService bookService = new BookService();
    private static final String NO_BOOK_FOUND = "there is no book available with that ID";
    private static final int _404_ERROR_CODE = 404;
	private static final String BOOK_CREATED = "book created successfully";
	private static final String BOOK_URI = "webapi/rest/book/";
    
    @GET
    @Path("books")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getAllBooks(){        					//need to add Type in List as this uses @XmlRootElement
    	LOGGER.info("entering path webapi/rest/books");
    	List<Book> books = bookService.getAllBooks();
    	return books;
    }
    
    @GET
    @Path("book/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book getBook(@PathParam("id") int id) {
    	LOGGER.info("entering path webapi/rest/book/" + id);
    	Book book = bookService.getBook(id);
    	if (book != null) {
    		LOGGER.info("book found, returning book");
            return book;
		}else {
			LOGGER.info("no book found, return error message");
			BookNotFoundResponse bookResponse = new BookNotFoundResponse(NO_BOOK_FOUND, _404_ERROR_CODE);
			return bookResponse;
		}    	
    }
    
    @POST
    @Path("book/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CreateBookResponse createBook(Book createBook) {
    	LOGGER.info("create book request received: " + createBook);
    	BookService.addToBookList(createBook);
    	int newBookId = bookService.getAllBooks().size();
        return new CreateBookResponse(BOOK_CREATED, BOOK_URI+newBookId);
    }
   
    @GET
    @Path("book/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DeleteBookResponse deleteBook(@PathParam("id") int id) {
    	LOGGER.info("request received to delete book with id: " + id);
    	Book deletedBook = bookService.deleteBook(id);
        return new DeleteBookResponse(deletedBook, true);
    }
}
