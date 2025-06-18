package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.mapper.BookMapper;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.repository.BookRepository;
import cz.dipcom.simulator.repository.filters.BookFilter;
import cz.dipcom.simulator.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Cacheable(value = "BOOK_CACHE", key = "#id" )
    @Override
    public BookDTO getBook(Long id) {
        BookEntity book = fetchBookById(id);
        return bookMapper.toDTO(book);
    }
    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getAllBooksFiltered(BookFilter bookFilter) {
        return bookRepository.findAllBooks(bookFilter,PageRequest.of(0,bookFilter.getLimit()))
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @CachePut(value = "BOOK_CACHE", key = "#result.idNum()")
    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookMapper.toEntity(bookDTO);
        bookEntity.setIdNum(null);
        return bookMapper.toDTO(bookRepository.save(bookEntity));
    }

    @CacheEvict(value = "BOOK_CACHE", key = "#id")
    @Override
    public BookDTO deleteBook(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BookDTO model = bookMapper.toDTO(book);
        bookRepository.delete(book);
        return model;
    }

    @Override
    public List<BookDTO> getBookByIsRestricted(boolean isRestricted) {
        return bookRepository.findByAccessRestricted(isRestricted)
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @CachePut(value = "BOOK_CACHE", key = "#result.idNum()")
    @Override
    public BookDTO editBook(Long id, BookDTO bookDTO) {
        System.out.println("sent DTO for edit: " + bookDTO);
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book with id " + id + " wasn't found in the database.");
        }
        BookEntity entity = bookMapper.toEntity(bookDTO);
        entity.setIdNum(id);
        BookEntity saved = bookRepository.save(entity);
        return bookMapper.toDTO(saved);
    }

    @Override
    public BookEntity fetchBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book with id " + id + " wasn't found in the database."));
    }
}
