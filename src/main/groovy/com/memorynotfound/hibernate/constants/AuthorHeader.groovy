package com.memorynotfound.hibernate.constants

import com.memorynotfound.hibernate.Author

enum AuthorHeader {
	AUTHOR("name"){
		public Author doSomething(Author author, String data) {
			author.name = data
			return author
		}
	}
	
	AuthorHeader(String headerLabel) {
		this.headerLabel = headerLabel
	}
	
	private final String headerLabel
	
	String getHeaderLabel() {
		return this.headerLabel
	}
	
	public abstract Author doSomething(Author author, String data)
}
