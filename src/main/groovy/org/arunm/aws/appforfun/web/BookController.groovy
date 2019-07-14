package org.arunm.aws.appforfun.web

import org.arunm.aws.appforfun.persistence.Book
import org.arunm.aws.appforfun.persistence.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController {

    @Autowired
    BookRepository bookRepository

    @GetMapping
    Iterable findAll() {
        println "Inside FindAll"
        bookRepository.findAll()
    }

    @GetMapping("/title/{bookTitle}")
    List findByTitle(@PathVariable String bookTitle) {
        bookRepository.findByTitle(bookTitle)
    }

    @GetMapping("/{id}")
    Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow({
            println "could not find book"
            new BookNotFoundException("InValid Book Id")
            });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book create(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow({new BookNotFoundException("InValid Book Id")});
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException("Id Mismatch");
        }
        bookRepository.findById(id)
                .orElseThrow({new BookNotFoundException("InValid Book Id")});
        bookRepository.save(book);
    }
}
