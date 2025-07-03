package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.mapper.BookMapper;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.repository.BookRepository;
import cz.dipcom.simulator.repository.filters.BookFilter;
import cz.dipcom.simulator.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing Book Entity persistence and fetching logic
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    /**
     * gets book according to its numericalId
     *
     * @param id
     * @return BookDTO
     */
    @Cacheable(value = "BOOK_CACHE", key = "#id")
    @Override
    public BookDTO getBook(Long id) {
        BookEntity book = fetchBookById(id);
        return bookMapper.toDTO(book);
    }

    /**
     * Gets all books without any filters
     *
     * @return List<BookDTO>
     */
    @Cacheable(value = "BOOK_LIST")
    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Gets all books according to the filter
     *
     * @param bookFilter
     * @return List<BookDTO>
     */
    @Cacheable(value = "BOOK_LIST_FILTERED")
    @Override
    public List<BookDTO> getAllBooksFiltered(BookFilter bookFilter) {

        return bookRepository.findAllBooks(bookFilter, PageRequest.of(bookFilter.getPage(), bookFilter.getLimit()))
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }


    /**
     * Adds a new Entity to the database
     *
     * @param bookDTO
     * @return BookDTO bookDTO
     */
    @Caching(evict = {
            @CacheEvict(value = "BOOK_LIST", allEntries = true),
            @CacheEvict(value = "BOOK_LIST_FILTERED", allEntries = true),
            @CacheEvict(value = "BOOK_CACHE", key = "#result.getIdNum()")
    }, put = {
            @CachePut(value = "BOOK_CACHE", key = "#result.getIdNum()")
    }
    )
    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookMapper.toEntity(bookDTO);
        bookEntity.setIdNum(null);
        return bookMapper.toDTO(bookRepository.save(bookEntity));
    }


    /**
     * Deletes an entity according to its id
     *
     * @param id
     * @return BookDTO
     */
    @Caching(evict = {
            @CacheEvict(value = "BOOK_LIST", allEntries = true),
            @CacheEvict(value = "BOOK_LIST_FILTERED", allEntries = true),
            @CacheEvict(value = "BOOK_CACHE", key = "#id")
    })
    @Override
    public BookDTO deleteBook(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BookDTO model = bookMapper.toDTO(book);
        bookRepository.delete(book);
        return model;
    }


    /**
     * Finds books that have access_restricted true/false
     *
     * @param isRestricted
     * @return List<BookDTO>
     */
    @Override
    public List<BookDTO> getBookByIsRestricted(boolean isRestricted) {
        return bookRepository.findByAccessRestricted(isRestricted)
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Edits an existing Entity in the database using a new DTO and overwriting the old one
     *
     * @param bookDTO
     * @param id
     * @return BookDTO bookDTO
     */
    @Caching(evict = {
            @CacheEvict(value = "BOOK_LIST", allEntries = true),
            @CacheEvict(value = "BOOK_LIST_FILTERED", allEntries = true),
            @CacheEvict(value = "BOOK_CACHE", key = "#result.getIdNum()")
    }, put = {
            @CachePut(value = "BOOK_CACHE", key = "#result.getIdNum()")
    }
    )
    @Override
    public BookDTO editBook(Long id, BookDTO bookDTO) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book with id " + id + " wasn't found in the database.");
        }
        BookEntity entity = bookMapper.toEntity(bookDTO);
        entity.setIdNum(id);
        BookEntity saved = bookRepository.save(entity);
        return bookMapper.toDTO(saved);
    }

    /**
     * reusalble function with error handling for finding books by id
     *
     * @param id
     * @return BookEntity
     */
    @Override
    public BookEntity fetchBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book with id " + id + " wasn't found in the database."));
    }


    /**
     * method for saving a list of BookDTOs, had to use batching approach
     * due to the errors while parsing the JSON
     *
     * @param bookDTOs
     * @return List<BookDTO>
     */
    @Override
    public List<BookDTO> saveBooks(List<BookDTO> bookDTOs) {
        List<BookEntity> books = bookDTOs.stream()
                .map(bookMapper::toEntity)
                .toList();

        List<BookEntity> savedBooks = bookRepository.saveAll(books); // Save and retrieve
        return savedBooks.stream()
                .map(bookMapper::toDTO) // Convert back to DTO with IDs
                .toList();
    }
}
