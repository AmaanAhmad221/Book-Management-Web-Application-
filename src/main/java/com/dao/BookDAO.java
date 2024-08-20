package com.dao;

import java.util.List;

import com.model.Book;

public interface BookDAO {
	public int saveBook(Book book);

	public int deleteBook(int id);

	public int updateBook(Book book);

	public List<Book> getAlLBooks();

	public Book getBookById(int id);
}
