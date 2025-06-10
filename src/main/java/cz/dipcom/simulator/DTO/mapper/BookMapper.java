package cz.dipcom.simulator.DTO.mapper;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity toEntity(BookDTO DTO);
    BookDTO toDTO(BookEntity entity);
}
