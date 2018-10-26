package com.sathya.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Passport {
	@Id
	private   int  passportNo;
	
	@Temporal(TemporalType.DATE)
	private   Date  expdate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="personid_fk", unique=true, nullable=false)
	private   Person  person;
	
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
