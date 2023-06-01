package kz.itstep.jwtsecurity.controller;

import kz.itstep.jwtsecurity.model.Book;
import kz.itstep.jwtsecurity.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookbyId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('LIBRARIAN')")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('LIBRARIAN')")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateById(book.getId(), book.getTitle(), book.getAuthor()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteById(id));
    }

}
