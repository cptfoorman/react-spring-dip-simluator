package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.SegmentDTO;
import cz.dipcom.simulator.entity.SegmentEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T16:40:59+0200",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class SegmentMapperImpl implements SegmentMapper {

    @Override
    public SegmentEntity toEntity(SegmentDTO DTO) {
        if ( DTO == null ) {
            return null;
        }

        SegmentEntity segmentEntity = new SegmentEntity();

        segmentEntity.setId( DTO.getId() );
        segmentEntity.setUrl( DTO.getUrl() );
        segmentEntity.setCount( DTO.getCount() );
        segmentEntity.setLink( DTO.getLink() );

        return segmentEntity;
    }

    @Override
    public SegmentDTO toDTO(SegmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SegmentDTO segmentDTO = new SegmentDTO();

        segmentDTO.setId( entity.getId() );
        segmentDTO.setUrl( entity.getUrl() );
        segmentDTO.setCount( entity.getCount() );
        segmentDTO.setLink( entity.getLink() );

        return segmentDTO;
    }
}
