package com.borjius.graphql.books;

import com.borjius.graphql.authors.Author;
import com.borjius.graphql.authors.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(final BookService bookService, final AuthorService authorService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getById(book.getAuthorId());
    }
}
