package com.borjius.graphql.authors;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private static List<Author> authors = List.of(
            new Author("author-1", "Joanne", "Rowling"),
            new Author("author-2", "Herman", "Melville"),
            new Author("author-3", "Anne", "Rice")
    );

    public Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}
