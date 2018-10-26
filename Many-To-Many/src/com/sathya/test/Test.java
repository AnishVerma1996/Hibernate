package com.sathya.test;

import com.sathya.dao.IMTMDao;
import com.sathya.dao.MTMDaoImpl;

public class Test {
	public static void main(String args[])
	{
		IMTMDao  dao=new  MTMDaoImpl();
		//dao.saveBooksAndAuthors();
		dao.removeAuthorFromBook(903, 10101);
	}

}
