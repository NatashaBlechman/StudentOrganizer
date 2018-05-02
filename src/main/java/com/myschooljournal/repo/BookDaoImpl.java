package com.myschooljournal.repo;

import com.myschooljournal.dao.BookDao;
import com.myschooljournal.entity.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {

    private static Map<Long,Book> booksRepo=new HashMap<>();
    private static Long idGen = 1L;

    @Override
    public List<Book> getByAuthor(String author) {
        return booksRepo.values()
                .stream()
                .filter(book->book.getAuthor()
                        .equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    @Override
    public Book getByTitle(String title) {
       return booksRepo.values().stream()
               .filter(book->book.getTitle()
                       .equalsIgnoreCase(title)).findAny().get();
    }

    @Override
    public Book save(Book book) {
        book.setId(idGen);
        return booksRepo.put(idGen++,book);
    }

    @Override
    public Book getById(Long id) {
        return booksRepo.get(id);
    }

    @Override
    public Book remove(Long id) {
        return booksRepo.remove(id);
    }

    @Override
    public Collection<Book> getAll() {
        return booksRepo.values();
    }

    @Override
    public Book update(Long id, Book book) {
        book.setId(id);
        booksRepo.put(id,book);
        return booksRepo.get(id);
    }
}
