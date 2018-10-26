package com.sathya.test;

import com.sathya.dao.IOTODao;
import com.sathya.dao.OTODaoImpl;

public class Test {
	public  static void  main(String args[])
	{
		IOTODao  dao = new  OTODaoImpl();
		dao.savePassportWithPerson();
	}

}
