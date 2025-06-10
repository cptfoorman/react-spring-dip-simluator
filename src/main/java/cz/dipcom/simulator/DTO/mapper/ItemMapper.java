package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity toEntity(ItemDTO DTO);
    ItemDTO toDTO(ItemEntity entity);
}
