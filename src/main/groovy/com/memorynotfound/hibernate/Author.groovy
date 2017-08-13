package com.memorynotfound.hibernate

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.OneToMany

@Entity
@NamedQueries(value = [
	@NamedQuery(name = "Author.getAll", query = "SELECT b FROM Author b")
])
class Author {

	@Id
	String name

	@OneToMany(mappedBy="author")
	List<Book> books
	
	
	Author() {
	}
	
	Author(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	List<Book> getBooks() {
		return books;
	}

	void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	String toString() {
		return "Author{" +
				"name='" + name + '\'' +
				'}';
	}
}
