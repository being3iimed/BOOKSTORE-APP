package com.books.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.bookStore.service.MyBookService;

@Controller
public class MyBooksController {
	
	@Autowired
	private MyBookService myBookService;
	
	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		myBookService.deleteById(id);
		
		return "redirect:/my_books";
	}
}
