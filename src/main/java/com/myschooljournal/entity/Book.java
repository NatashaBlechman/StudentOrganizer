package com.myschooljournal.entity;

import java.util.Objects;

public class Book extends EntityObject {

    private String title;
    private String author;
    private String link;


    public Book(String title,String author,String link) {
        this.title = title;
        this.author=author;
        this.link=link;
    }
    public Book(){};

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getLink(), book.getLink());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getAuthor(), getLink());
    }
}
