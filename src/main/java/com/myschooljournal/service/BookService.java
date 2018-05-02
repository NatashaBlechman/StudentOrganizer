package com.myschooljournal.service;

import com.myschooljournal.dao.BookDao;
import com.myschooljournal.entity.Book;

import java.util.Collection;
import java.util.List;


public class BookService {

    private BookDao bookDao;

    public   BookService(BookDao bookDao){
        this.bookDao=bookDao;
    }

    public  BookService(){

    }

    public List<Book> getByAuthor(String author) {
        return bookDao.getByAuthor(author);
    }


    public Book getByTitle(String title) {
        return bookDao.getByTitle(title);
    }


    public Book save(Book book) {
        return bookDao.save(book);
    }


    public Book getById(Long id) {
        return bookDao.getById(id);
    }


    public Book remove(Long id) {
      return bookDao.remove(id);
    }


    public Collection<Book> getAll() {
        return bookDao.getAll();
    }


    public Book update(Long id, Book book) {
        return bookDao.update(id,book);
    }








}
