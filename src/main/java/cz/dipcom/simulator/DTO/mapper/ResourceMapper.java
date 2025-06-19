package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ResourceEntity;
import org.mapstruct.Mapper;

/**
 * Mapping Class for converting entities and DTOs,
 * used org.mapstruct since writing this logic with hands is very prone to errors
 */
@Mapper(componentModel = "spring")
public interface ResourceMapper {
    ResourceEntity toEntity(ResourceDTO DTO);
    ResourceDTO toDTO(ResourceEntity entity);
}
