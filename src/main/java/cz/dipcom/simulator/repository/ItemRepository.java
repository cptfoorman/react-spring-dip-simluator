package cz.dipcom.simulator.repository;


import cz.dipcom.simulator.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
