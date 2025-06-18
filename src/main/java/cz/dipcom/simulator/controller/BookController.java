package cz.dipcom.simulator.controller;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.repository.filters.BookFilter;
import cz.dipcom.simulator.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping({"/books"})
    private List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping({"/books/filter"})
    private List<BookDTO> getAllBooksFiltered(@ModelAttribute BookFilter bookFilter){
        return bookService.getAllBooksFiltered(bookFilter);
    }
    @GetMapping("/books/restricted")
    private List<BookDTO> getRestrictedBooks(){
        return bookService.getBookByIsRestricted(true);
    }
    @GetMapping("/book/{id}")
    private BookDTO getBookById(@PathVariable Long id){
        return bookService.getBook(id);
    }
    @PutMapping("/book/edit/{id}")
    private BookDTO editBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return bookService.editBook(id, bookDTO);
    }
    @PostMapping("/book/new")
    private BookDTO newBook(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO);
        return bookService.addBook(bookDTO);
    }
    @DeleteMapping("/book/delete/{id}")
    private BookDTO deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}
