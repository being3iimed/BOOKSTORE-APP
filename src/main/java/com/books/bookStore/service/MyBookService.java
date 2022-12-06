package com.books.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.bookStore.entity.MyBookList;
import com.books.bookStore.repository.MyBooksRepo;

@Service
public class MyBookService {

		@Autowired
		private MyBooksRepo mybooks;
		
		
		public void saveMyBook(MyBookList book) {
			mybooks.save(book);		
		}
		
		public List<MyBookList> getAllBooks(){
			return mybooks.findAll();
		}
		public void deleteById(int id) {
			mybooks.deleteById(id);
		}
}
