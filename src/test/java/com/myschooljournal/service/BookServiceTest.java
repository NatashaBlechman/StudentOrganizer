package com.myschooljournal.service;

import com.myschooljournal.dao.BookDao;
import com.myschooljournal.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookService bookService;

    @Test
    public void shouldReturnBooksByAuthor(){
        Book book=new Book();
        List<Book> expected= Arrays.asList(book,book);
        when(bookDao.getByAuthor("Dahl Roald")).thenReturn(expected);
        List<Book> actual=bookService.getByAuthor("Dahl Roald");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnBookByTitle(){
       Book expected=new Book();
       when(bookDao.getByTitle("The Witches")).thenReturn(expected);
       Book actual=bookService.getByTitle("The Witches");
       Assert.assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnBookWhichWasSaving(){
        Book expected=new Book();
        when(bookDao.save(expected)).thenReturn(expected);
        Book actual=bookService.save(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnBookById(){
        Book expected=new Book();
        when(bookDao.getById(1L)).thenReturn(expected);
        Book actual=bookService.getById(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnBookWhichWasRemovedById(){
        Book expected=new Book();
        when(bookDao.remove(1L)).thenReturn(expected);
        Book actual=bookService.remove(1L);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnAllBooks(){
        Collection<Book> expected= Collections.singleton(new Book());
        when(bookDao.getAll()).thenReturn(expected);
        Collection<Book> actual=bookService.getAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnBookWhichWasUpdate(){
        Book expected=new Book();
        when(bookDao.update(1L,expected)).thenReturn(expected);
        Book actual=bookService.update(1L,expected);
        Assert.assertEquals(expected,actual);
    }
}
