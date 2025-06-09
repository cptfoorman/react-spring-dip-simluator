package cz.dipcom.simulator.repository;

import cz.dipcom.simulator.entity.SegmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<SegmentEntity,Long> {
}
