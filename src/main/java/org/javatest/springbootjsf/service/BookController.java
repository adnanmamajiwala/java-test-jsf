package org.javatest.springbootjsf.service;

import org.javatest.springbootjsf.model.Book;
import org.javatest.springbootjsf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/service/books")
    public Iterable<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @RequestMapping(value = "/service/book/{id}", method = GET)
    public Book getBookById(@PathVariable Long id) {
        return this.bookRepository.findOne(id);
    }
}
