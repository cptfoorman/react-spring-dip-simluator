package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.SegmentDTO;
import cz.dipcom.simulator.entity.SegmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 * Mapping Class for converting entities and DTOs,
 * used org.mapstruct since writing this logic with hands is very prone to errors
 */
@Mapper(componentModel = "spring")
public interface SegmentMapper {
    SegmentEntity toEntity(SegmentDTO DTO);
    SegmentDTO toDTO(SegmentEntity entity);
}
