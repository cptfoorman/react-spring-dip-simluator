package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookDTO getBook(Long id);

    List<BookDTO> getAllBooks();

    BookDTO addBook(BookDTO bookDTO);

    BookDTO deleteBook(Long id);

    BookDTO editBook(Long id, BookDTO bookDTO);

    BookEntity fetchBookById(Long id);
}
