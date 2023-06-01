package kz.itstep.jwtsecurity.service;

import kz.itstep.jwtsecurity.model.Book;
import kz.itstep.jwtsecurity.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String saveBook(Book book){
        if(book != null && book.getTitle()!=null){
            bookRepository.save(book);
            return "book was saved";
        }
        else{
            return "error";
        }
    }

    public List<Book> findAll(){
         return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public String deleteById(Long id){
        bookRepository.deleteById(id);
        return "book with id:"+id+" was deleted";
    }

    public String updateById(Long id, String title, String author){
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.save(book);
        return "book with id:"+id+" was updated";
    }
}
