package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.entity.ItemEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T10:30:30+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemEntity toEntity(ItemDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        return itemEntity;
    }

    @Override
    public ItemDTO toDTO(ItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        return itemDTO;
    }
}
