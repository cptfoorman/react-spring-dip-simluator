package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T22:23:06+0200",
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

        itemEntity.setId( DTO.getId() );
        itemEntity.setTitle( DTO.getTitle() );
        List<String> list = DTO.getCreatedPublished();
        if ( list != null ) {
            itemEntity.setCreatedPublished( new ArrayList<String>( list ) );
        }
        List<String> list1 = DTO.getCallNumber();
        if ( list1 != null ) {
            itemEntity.setCallNumber( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = DTO.getContributors();
        if ( list2 != null ) {
            itemEntity.setContributors( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = DTO.getFormat();
        if ( list3 != null ) {
            itemEntity.setFormat( new ArrayList<String>( list3 ) );
        }
        List<String> list4 = DTO.getLanguage();
        if ( list4 != null ) {
            itemEntity.setLanguage( new ArrayList<String>( list4 ) );
        }
        List<String> list5 = DTO.getMedium();
        if ( list5 != null ) {
            itemEntity.setMedium( new ArrayList<String>( list5 ) );
        }
        List<String> list6 = DTO.getNotes();
        if ( list6 != null ) {
            itemEntity.setNotes( new ArrayList<String>( list6 ) );
        }

        return itemEntity;
    }

    @Override
    public ItemDTO toDTO(ItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( entity.getId() );
        itemDTO.setTitle( entity.getTitle() );
        List<String> list = entity.getCreatedPublished();
        if ( list != null ) {
            itemDTO.setCreatedPublished( new ArrayList<String>( list ) );
        }
        List<String> list1 = entity.getCallNumber();
        if ( list1 != null ) {
            itemDTO.setCallNumber( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = entity.getContributors();
        if ( list2 != null ) {
            itemDTO.setContributors( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = entity.getFormat();
        if ( list3 != null ) {
            itemDTO.setFormat( new ArrayList<String>( list3 ) );
        }
        List<String> list4 = entity.getLanguage();
        if ( list4 != null ) {
            itemDTO.setLanguage( new ArrayList<String>( list4 ) );
        }
        List<String> list5 = entity.getMedium();
        if ( list5 != null ) {
            itemDTO.setMedium( new ArrayList<String>( list5 ) );
        }
        List<String> list6 = entity.getNotes();
        if ( list6 != null ) {
            itemDTO.setNotes( new ArrayList<String>( list6 ) );
        }

        return itemDTO;
    }
}
