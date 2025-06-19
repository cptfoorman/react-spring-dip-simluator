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
            " AND (:#{#filter.getLanguage()} IS NULL OR :#{#filter.getLanguage()} IN (SELECT lang FROM b.language lang))" +
            " AND (:#{#filter.getMimeType()} IS NULL OR :#{#filter.getMimeType()} IN (SELECT mime FROM b.mimeType mime))" +
            " AND (:#{#filter.getAccessRestricted()} IS NULL OR b.accessRestricted = :#{#filter.getAccessRestricted()})" +
            " AND (:#{#filter.getDateFrom()} IS NULL OR b.date >= :#{#filter.getDateFrom()})" +
            " AND (:#{#filter.getDateTo()} IS NULL OR b.date <= :#{#filter.getDateTo()})"
    )
    List<BookEntity> findAllBooks(@Param("filter") BookFilter filter, Pageable pageable);

    List<BookEntity> findByAccessRestricted(boolean isRestricted);



}

