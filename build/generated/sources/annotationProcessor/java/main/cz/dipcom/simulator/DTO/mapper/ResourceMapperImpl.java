package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.entity.ResourceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-19T14:36:16+0200",
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

        resourceEntity.setId( DTO.getId() );
        resourceEntity.setDjvuTextFile( DTO.getDjvuTextFile() );
        resourceEntity.setFulltextDerivative( DTO.getFulltextDerivative() );
        resourceEntity.setFulltextFile( DTO.getFulltextFile() );
        resourceEntity.setImage( DTO.getImage() );
        resourceEntity.setPaprikaResourcePath( DTO.getPaprikaResourcePath() );
        resourceEntity.setPdf( DTO.getPdf() );
        resourceEntity.setSearch( DTO.getSearch() );
        resourceEntity.setUrl( DTO.getUrl() );
        resourceEntity.setFiles( DTO.getFiles() );
        resourceEntity.setRepresentativeIndex( DTO.getRepresentativeIndex() );
        resourceEntity.setSegments( DTO.getSegments() );
        resourceEntity.setVersion( DTO.getVersion() );

        return resourceEntity;
    }

    @Override
    public ResourceDTO toDTO(ResourceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setId( entity.getId() );
        resourceDTO.setDjvuTextFile( entity.getDjvuTextFile() );
        resourceDTO.setFulltextDerivative( entity.getFulltextDerivative() );
        resourceDTO.setFulltextFile( entity.getFulltextFile() );
        resourceDTO.setImage( entity.getImage() );
        resourceDTO.setPaprikaResourcePath( entity.getPaprikaResourcePath() );
        resourceDTO.setPdf( entity.getPdf() );
        resourceDTO.setSearch( entity.getSearch() );
        resourceDTO.setUrl( entity.getUrl() );
        resourceDTO.setRepresentativeIndex( entity.getRepresentativeIndex() );
        resourceDTO.setVersion( entity.getVersion() );
        resourceDTO.setSegments( entity.getSegments() );
        resourceDTO.setFiles( entity.getFiles() );

        return resourceDTO;
    }
}
