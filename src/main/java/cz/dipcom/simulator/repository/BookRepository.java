package cz.dipcom.simulator.repository;


import cz.dipcom.simulator.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
