package com.books.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.bookStore.entity.Book;
import com.books.bookStore.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo BRepo;
	
	// adding a book
	public void save(Book b) {
		BRepo.save(b);
	}

	public List<Book> getAllBook(){
		return BRepo.findAll();
	}
	public Book getBookById(int id) {
		return BRepo.findById(id).get();
	}
	public void deleteById(int id) {
		BRepo.deleteById(id);
	}
}

