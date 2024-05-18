package org.hibernatelearning.controller;


import org.hibernatelearning.domain.Book;
import org.hibernatelearning.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    ResponseEntity<Book> getBooks(@RequestParam String bookTitle) {

        //localhost:8080/api/books?bookTitle=Self
        //insert into book values (1, '1234', 'Sastry', 'Self');
        Book books = bookRepository.findByTitle(bookTitle);
        return ResponseEntity.ok(books);
    }
}
