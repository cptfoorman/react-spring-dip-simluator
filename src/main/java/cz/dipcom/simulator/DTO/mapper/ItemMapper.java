package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ItemEntity;

public interface ItemMapper {
    ItemEntity toEntity(ItemDTO DTO);
    ItemDTO toDTO(ItemEntity entity);
}
