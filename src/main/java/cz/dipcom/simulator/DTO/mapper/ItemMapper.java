package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ItemEntity;
import org.mapstruct.Mapper;

/**
 * Mapping Class for converting entities and DTOs,
 * used org.mapstruct since writing this logic with hands is very prone to errors
 */
@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity toEntity(ItemDTO DTO);
    ItemDTO toDTO(ItemEntity entity);
}
