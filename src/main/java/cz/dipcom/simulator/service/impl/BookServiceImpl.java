package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.mapper.BookMapper;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.repository.BookRepository;
import cz.dipcom.simulator.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDTO getBook(Long id) {
        BookEntity book = fetchBookById(id);
        return bookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return List.of();
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public BookDTO deleteBook(Long id) {
        return null;
    }

    @Override
    public BookDTO editBook(Long id, BookDTO bookDTO) {
        return null;
    }

    @Override
    public BookEntity fetchBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book with id " + id + " wasn't found in the database."));
    }
}
