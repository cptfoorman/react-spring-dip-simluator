package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.SegmentDTO;
import cz.dipcom.simulator.entity.SegmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SegmentMapper {
    @Mapping(target = "book", ignore = true)
    SegmentEntity toEntity(SegmentDTO DTO);
    SegmentDTO toDTO(SegmentEntity entity);
}
