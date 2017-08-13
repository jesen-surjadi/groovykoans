package com.memorynotfound.hibernate

import static org.junit.Assert.*

import java.sql.Connection
import java.sql.SQLException

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

import org.h2.tools.RunScript
import org.hibernate.Session
import org.hibernate.jdbc.Work
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class JPAHibernateTest {
	protected static EntityManagerFactory emf;
	protected static EntityManager em;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("mnf-pu-test");
        em = emf.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        em.clear();
        em.close();
        emf.close();
	}

	@Before
	public void setUp() throws Exception {
        Session session = em.unwrap(Session.class);
	}


}
