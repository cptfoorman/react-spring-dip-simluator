package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.repository.filters.BookFilter;
import org.springframework.data.domain.Pageable;

import java.awt.print.Book;
import java.net.http.HttpResponse;
import java.util.List;

public interface BookService {

    BookDTO getBook(Long id);

    List<BookDTO> getAllBooksFiltered(BookFilter bookFilter);

    List<BookDTO> getAllBooks();
    BookDTO addBook(BookDTO bookDTO);

    BookDTO deleteBook(Long id);

    List<BookDTO> getBookByIsRestricted(boolean isRestricted);

    BookDTO editBook(Long id, BookDTO bookDTO);

    BookEntity fetchBookById(Long id);

    List<BookDTO> saveBooks(List<BookDTO> bookDTOS);
}
