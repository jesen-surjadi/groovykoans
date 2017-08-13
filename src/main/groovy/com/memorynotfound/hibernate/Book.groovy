package com.memorynotfound.hibernate

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery

@Entity
@NamedQueries(value = [
	@NamedQuery(name = "Book.getAll", query = "SELECT b FROM Book b"),
	@NamedQuery(name = "Book.getAuthors", query = "SELECT distinct b.author FROM Book b")
])
class Book {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(updatable = true, nullable = false)
		Integer id;
		
		String title;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="author_name")
		Author author;

		Book() {
	    }
	
		Book(Integer id, String title) {
			this.id = id;
			this.title = title;
		}
	
		Book(String title) {
			this.title = title;
		}
	
		Integer getId() {
			return id;
		}
	
		void setId(Integer id) {
			this.id = id;
		}
	
		String getTitle() {
			return title;
		}
	
		void setTitle(String title) {
			this.title = title;
		}

	    Author getAuthor() {
			return author;
		}

		void setAuthor(Author author) {
			this.author = author;
		}
	
		@Override
		String toString() {
			return "Book{" +
					"id=" + id +
					", title='" + title + '\'' +
					'}';
		}
}
