package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.entity.BookEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T10:30:31+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity toEntity(BookDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        return bookEntity;
    }

    @Override
    public BookDTO toDTO(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        return bookDTO;
    }
}
