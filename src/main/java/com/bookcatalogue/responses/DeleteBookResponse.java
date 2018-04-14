package com.bookcatalogue.responses;

import javax.xml.bind.annotation.XmlRootElement;

import com.bookcatalogue.model.Book;

@XmlRootElement
public class DeleteBookResponse {
	
	private Book book;
	private boolean deletedStatus;
	
	public DeleteBookResponse() {}
	
	public DeleteBookResponse(Book book, boolean deletedStatus) {
		this.book = book;
		this.deletedStatus = deletedStatus;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean isDeletedStatus() {
		return deletedStatus;
	}
	public void setDeletedStatus(boolean deletedStatus) {
		this.deletedStatus = deletedStatus;
	}
	
	

}
