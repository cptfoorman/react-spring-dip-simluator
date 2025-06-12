package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.entity.ResourceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T10:30:31+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ResourceMapperImpl implements ResourceMapper {

    @Override
    public ResourceEntity toEntity(ResourceDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        ResourceEntity resourceEntity = new ResourceEntity();

        return resourceEntity;
    }

    @Override
    public ResourceDTO toDTO(ResourceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        return resourceDTO;
    }
}
