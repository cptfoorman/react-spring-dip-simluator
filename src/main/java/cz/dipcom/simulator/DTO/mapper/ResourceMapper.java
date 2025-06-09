package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ResourceEntity;

public interface ResourceMapper {
    ResourceEntity toEntity(ResourceDTO DTO);
    ResourceDTO toDTO(ResourceEntity entity);
}
