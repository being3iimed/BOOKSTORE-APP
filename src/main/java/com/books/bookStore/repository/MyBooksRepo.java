package com.books.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.bookStore.entity.MyBookList;

@Repository
public interface MyBooksRepo extends JpaRepository<MyBookList, Integer> {

}
