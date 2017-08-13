package com.memorynotfound.hibernate.constants

import com.memorynotfound.hibernate.Author
import com.memorynotfound.hibernate.Book

enum BookHeader {
	ID("id"){
		public Book doSomething(Book book, String data) {
			book.setId(Integer.valueOf(data))
			return book
		}
	},
	TITLE("book title"){
		public Book doSomething(Book book, String data) {
			book.setTitle(data)
			return book
		}
	},
	AUTHOR("author name"){
		public Book doSomething(Book book, String data) {
			book.setAuthor(new Author(data))
			return book
		}
	}
	
	BookHeader(String headerLabel) {
		this.headerLabel = headerLabel
	}
	
	private final String headerLabel
	
	String getHeaderLabel() {
		return this.headerLabel
	}
	
	public abstract Book doSomething(Book book, String data)
}
