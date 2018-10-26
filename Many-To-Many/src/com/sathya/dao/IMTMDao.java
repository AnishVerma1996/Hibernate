package com.sathya.dao;

public interface IMTMDao {
	void  saveBooksAndAuthors();
	void  removeAuthorFromBook(int  authid,int bookid);
}
