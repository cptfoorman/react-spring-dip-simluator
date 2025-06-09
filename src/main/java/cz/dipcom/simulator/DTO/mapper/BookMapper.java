package cz.dipcom.simulator.DTO.mapper;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.entity.BookEntity;

public interface BookMapper {
    BookEntity toEntity(BookDTO DTO);
    BookDTO toDTO(BookEntity entity);
}
