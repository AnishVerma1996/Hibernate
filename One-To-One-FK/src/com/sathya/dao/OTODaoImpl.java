package com.sathya.dao;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Passport;
import com.sathya.entity.Person;
import com.sathya.util.HibernateUtil;

public class OTODaoImpl implements IOTODao {
	private   SessionFactory  factory;
	public OTODaoImpl() {
		factory=HibernateUtil.getSessionFactory();
	}
	
	

	@Override
	public void savePassportWithPerson() {
		Person  person = new  Person();
		person.setPersonId(1101101);
		person.setPersonName("A");
		
		Passport  passport=new  Passport();
		passport.setPassportNo(8099213);
		try {
			SimpleDateFormat sdf = new  SimpleDateFormat("dd-MM-yyyy");
			java.util.Date  expireDate=sdf.parse("31-12-2019");
			passport.setExpdate(expireDate);
		}catch(Exception  e)
		{   System.out.println(e);  }
		
		passport.setPerson(person);
		Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		session.save(passport);
		tx.commit();
		session.close();
	}

}
