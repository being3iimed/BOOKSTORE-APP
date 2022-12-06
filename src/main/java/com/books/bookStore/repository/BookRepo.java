package com.books.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.bookStore.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
