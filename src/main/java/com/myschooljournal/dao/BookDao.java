package com.myschooljournal.dao;

import com.myschooljournal.entity.Book;

import java.util.List;

public interface BookDao extends CommonDao<Book> {

    List<Book> getByAuthor(String author);
    Book  getByTitle(String title);
}
