package com.sathya.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Author;
import com.sathya.entity.Book;
import com.sathya.util.HibernateUtil;

public class MTMDaoImpl implements IMTMDao {
	private   SessionFactory  factory;
	public MTMDaoImpl() {
		factory=HibernateUtil.getSessionFactory();
	}

	@Override
	public void saveBooksAndAuthors() {
		Book   b1=new  Book();
		b1.setBookId(10101); b1.setBookName("Java");
		Book   b2=new  Book();
		b2.setBookId(10102); b2.setBookName("Hibernate");
		Author  a1=new  Author();
		a1.setAuthorId(901); a1.setAuthorName("A");
		Author  a2=new  Author();
		a2.setAuthorId(902); a2.setAuthorName("B");
		Author  a3=new  Author();
		a3.setAuthorId(903); a3.setAuthorName("C");
		
		Set<Author> authorsSet1=new  HashSet<>();
		authorsSet1.add(a1);
		authorsSet1.add(a3);
		b1.setAuthors(authorsSet1);
		
		Set<Author>  authorsSet2=new  HashSet<>();
		authorsSet2.add(a1);
		authorsSet2.add(a2);
		b2.setAuthors(authorsSet2);
		Session  session=factory.openSession();
		Transaction  tx=session.beginTransaction();
		session.save(b1);
		session.save(b2);
		tx.commit();
		session.close();
	}
	@Override
	public void removeAuthorFromBook(int authid, int bookid) {
		Session  session=factory.openSession();
		Book b =(Book)session.get(Book.class, bookid);
		Set<Author>  authors=b.getAuthors();
		Author  a=(Author)session.get(Author.class, authid);
		Transaction  tx = session.beginTransaction();
		authors.remove(a);
		tx.commit();
		session.close();
		
		
	}
	
	
	
	
	
	
	
	
	
}
