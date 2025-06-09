package cz.dipcom.simulator.repository;


import cz.dipcom.simulator.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity,Long> {
}
