package cz.dipcom.simulator.DTO.mapper;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Mapping Class for converting entities and DTOs,
 * used org.mapstruct since writing this logic with hands is very prone to errors
 */
@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface BookMapper {

    @Mapping(target = "timestamp", source = "timestamp", qualifiedByName = "mapOffsetDateTimeToString")
    @Mapping(target = "extractTimestamp", source = "extractTimestamp", qualifiedByName = "mapOffsetDateTimeToString")
    @Mapping(target = "item", source = "item")
    BookDTO toDTO(BookEntity book);

    @Mapping(target = "idNum", ignore = true)
    @Mapping(target = "extractTimestamp", source = "extractTimestamp", qualifiedByName = "mapDate")
    @Mapping(target = "timestamp", source = "timestamp", qualifiedByName = "mapDate")
    BookEntity toEntity(BookDTO bookDTO);

    @Named("mapDate")
    default OffsetDateTime mapDate(String dateString) {
        if (dateString == null || dateString.isBlank()) {
            return null;
        }
        return OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
    @Named("mapOffsetDateTimeToString")
    default String mapOffsetDateTimeToString(OffsetDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
