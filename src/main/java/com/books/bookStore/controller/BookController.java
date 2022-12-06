package com.books.bookStore.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.books.bookStore.entity.Book;
import com.books.bookStore.entity.MyBookList;
import com.books.bookStore.service.BookService;
import com.books.bookStore.service.MyBookService;


@Controller
public class BookController {
	
	 @Autowired
	 // book service object
	 private BookService service;
	
	 @Autowired
	 private MyBookService myBookService;
	 
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/register_book")
	public String RegisterBook() {
		return "RegisterBook";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
		//model & view object
		ModelAndView mv = new ModelAndView(); 
		// set the page that we want to show 
		mv.setViewName("bookList");
		
		/* the book can be any name and the second is
		the data in our case is is the list*/
		mv.addObject("book",list);
		return mv;	
	}
	
	@PostMapping("/save")
	// this method is presented in our book service class
	public String addBook(@ModelAttribute Book b) {
	// @ModelAttribute return the form data in our book object
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(org.springframework.ui.Model model) {
		List<MyBookList>list = myBookService.getAllBooks();
		model.addAttribute("book",list);
		
		return "myBooks";
	}
	@RequestMapping("/mybooklist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mbl = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		
		myBookService.saveMyBook(mbl);
		return "redirect:/my_books";
	}
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") int id,org.springframework.ui.Model model) {
		
		Book b = service.getBookById(id);

		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
}