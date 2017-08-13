package com.memorynotfound.hibernate

import static org.junit.Assert.*

import org.junit.Test

import com.memorynotfound.hibernate.constants.AuthorHeader
import com.memorynotfound.hibernate.constants.BookHeader
import com.memorynotfound.utils.CSVLoaderUtil

class JPAHibernateCRUDTest extends JPAHibernateTest {

    @Test
    public void testGetObjectById_success() {
        Book book = em.find(Book.class, 1);
        assertNull(book);
    }

    @Test
    public void testGetAll_success() {
        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();
        assertEquals(0, books.size());
    }

    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        em.persist(new Book("Unit Test Hibernate/JPA with in memory H2 Database"));
        em.getTransaction().commit();

        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();

        assertNotNull(books);
		assertTrue(books.size() > 0);
    }

    @Test
    public void testDelete_success(){
        Book book = em.find(Book.class, 1);

        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();

        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();
		
		assertNotNull(books);
		assertTrue(books.size() > 0);
    }

    @Test
    public void testRead_CSV(){
		
		
		File csv = new File(getClass().getResource("/book.csv").getFile());
		File authorcsv = new File(getClass().getResource("/author.csv").getFile());
		
		
		
		List<Author> authorList = CSVLoaderUtil.populateAuthor(authorcsv, AuthorHeader);
		assertEquals(3, authorList.size());
		
		List<Book> bookList = CSVLoaderUtil.populateBook(csv, BookHeader);
		assertEquals(9, bookList.size());
		
		em.getTransaction().begin();
		for(each in authorList) {
			em.persist(each)
		}
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		for(each in bookList) {
			em.merge(each)
		}
		em.getTransaction().commit();
		
        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();
        assertEquals(9, books.size());
		
		
		List<Author> authors = em.createNamedQuery("Author.getAll", Author.class).getResultList();
		assertEquals(3, authors.size());
		
        List<Author> bookAuthors = em.createNamedQuery("Book.getAuthors", Author.class).getResultList();
        assertEquals(3, bookAuthors.size());
    }
}
