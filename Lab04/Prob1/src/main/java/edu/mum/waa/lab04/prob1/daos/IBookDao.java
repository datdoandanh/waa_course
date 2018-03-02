package edu.mum.waa.lab04.prob1.daos;

import java.util.List;

import edu.mum.waa.lab04.prob1.entities.Book;


public interface IBookDao {

	public abstract List<Book> getAll();

	public abstract void add(Book book);

	public abstract Book get(int id);

	public abstract void update(int bookId, Book book);

	public abstract void delete(int bookId);

}