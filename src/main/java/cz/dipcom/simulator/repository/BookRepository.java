package cz.dipcom.simulator.repository;


import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.repository.filters.BookFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long>,JpaRepository<BookEntity,Long> {


    @Query(value = "SELECT b FROM BookEntity b WHERE" +
            " (:#{#filter.getTitle()} IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :#{#filter.getTitle()}, '%')))" +
            " AND (:#{#filter.getType()} IS NULL OR b.type = :#{#filter.getType()})" +
            " AND (:#{#filter.getYearFrom()} IS NULL OR b.date >= :#{#filter.getYearFrom()})" +
            " AND (:#{#filter.getYearTo()} IS NULL OR b.date <= :#{#filter.getYearTo()})" +
            " AND (:#{#filter.getLanguage()} IS NULL OR :#{#filter.getLanguage()} IN (SELECT lang FROM b.language lang))" +
            " AND (:#{#filter.getMimeType()} IS NULL OR :#{#filter.getMimeType()} IN (SELECT mime FROM b.mimeType mime))" +
            " AND (:#{#filter.getAccessRestricted()} IS NULL OR b.accessRestricted = :#{#filter.getAccessRestricted()})" +
            " AND (:#{#filter.getUrlId} IS NULL OR LOWER(b.urlId) LIKE LOWER(CONCAT('%', :#{#filter.getUrlId}, '%')))" +
            " AND (:#{#filter.getShelfId()} IS NULL OR LOWER(b.shelfId) LIKE LOWER(CONCAT('%', :#{#filter.getShelfId}, '%')))"+
            " AND (:#{#filter.getIndex} IS NULL OR b.index = :#{#filter.getIndex()})"
    )
    List<BookEntity> findAllBooks(@Param("filter") BookFilter filter, Pageable pageable);

    List<BookEntity> findByAccessRestricted(boolean isRestricted);



}

