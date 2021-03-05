package com.abc.lab2;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
@Entity
@Table(name="bookauthor_tbl")
*/
public class BookAuthor {
	//@Id
	//@OneToOne(cascade = CascadeType.ALL)
	private Book book;
	//@Id
	//@OneToOne(cascade = CascadeType.ALL)
	private Author auth;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author getAuth() {
		return auth;
	}
	public void setAuth(Author auth) {
		this.auth = auth;
	}

}
