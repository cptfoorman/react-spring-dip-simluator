package cz.dipcom.simulator.DTO.mapper;

import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.DTO.SegmentDTO;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ResourceEntity;
import cz.dipcom.simulator.entity.SegmentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T16:40:59+0200",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public BookDTO toDTO(BookEntity book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setTimestamp( mapOffsetDateTimeToString( book.getTimestamp() ) );
        bookDTO.setExtractTimestamp( mapOffsetDateTimeToString( book.getExtractTimestamp() ) );
        bookDTO.setItem( itemMapper.toDTO( book.getItem() ) );
        bookDTO.setIdNum( book.getIdNum() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setType( book.getType() );
        bookDTO.setUrl( book.getUrl() );
        bookDTO.setShelfId( book.getShelfId() );
        bookDTO.setUrlId( book.getUrlId() );
        bookDTO.setAccessRestricted( book.isAccessRestricted() );
        bookDTO.setDigitized( book.isDigitized() );
        bookDTO.setHasSegments( book.isHasSegments() );
        bookDTO.setDate( book.getDate() );
        List<String> list = book.getAka();
        if ( list != null ) {
            bookDTO.setAka( new ArrayList<String>( list ) );
        }
        List<String> list1 = book.getContributors();
        if ( list1 != null ) {
            bookDTO.setContributors( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = book.getLanguage();
        if ( list2 != null ) {
            bookDTO.setLanguage( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = book.getMimeType();
        if ( list3 != null ) {
            bookDTO.setMimeType( new ArrayList<String>( list3 ) );
        }
        List<String> list4 = book.getNumber();
        if ( list4 != null ) {
            bookDTO.setNumber( new ArrayList<String>( list4 ) );
        }
        List<String> list5 = book.getNumberLccn();
        if ( list5 != null ) {
            bookDTO.setNumberLccn( new ArrayList<String>( list5 ) );
        }
        List<String> list6 = book.getNumberOclc();
        if ( list6 != null ) {
            bookDTO.setNumberOclc( new ArrayList<String>( list6 ) );
        }
        List<String> list7 = book.getOnlineFormat();
        if ( list7 != null ) {
            bookDTO.setOnlineFormat( new ArrayList<String>( list7 ) );
        }
        List<String> list8 = book.getImageUrl();
        if ( list8 != null ) {
            bookDTO.setImageUrl( new ArrayList<String>( list8 ) );
        }
        List<String> list9 = book.getPartof();
        if ( list9 != null ) {
            bookDTO.setPartof( new ArrayList<String>( list9 ) );
        }
        bookDTO.setResources( resourceEntityListToResourceDTOList( book.getResources() ) );
        bookDTO.setSegments( segmentEntityListToSegmentDTOList( book.getSegments() ) );

        return bookDTO;
    }

    @Override
    public BookEntity toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setExtractTimestamp( mapDate( bookDTO.getExtractTimestamp() ) );
        bookEntity.setTimestamp( mapDate( bookDTO.getTimestamp() ) );
        bookEntity.setTitle( bookDTO.getTitle() );
        bookEntity.setType( bookDTO.getType() );
        bookEntity.setUrl( bookDTO.getUrl() );
        bookEntity.setShelfId( bookDTO.getShelfId() );
        bookEntity.setAccessRestricted( bookDTO.isAccessRestricted() );
        bookEntity.setDigitized( bookDTO.isDigitized() );
        bookEntity.setHasSegments( bookDTO.isHasSegments() );
        bookEntity.setUrlId( bookDTO.getUrlId() );
        bookEntity.setDate( bookDTO.getDate() );
        List<String> list = bookDTO.getAka();
        if ( list != null ) {
            bookEntity.setAka( new ArrayList<String>( list ) );
        }
        List<String> list1 = bookDTO.getContributors();
        if ( list1 != null ) {
            bookEntity.setContributors( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = bookDTO.getLanguage();
        if ( list2 != null ) {
            bookEntity.setLanguage( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = bookDTO.getMimeType();
        if ( list3 != null ) {
            bookEntity.setMimeType( new ArrayList<String>( list3 ) );
        }
        List<String> list4 = bookDTO.getNumber();
        if ( list4 != null ) {
            bookEntity.setNumber( new ArrayList<String>( list4 ) );
        }
        List<String> list5 = bookDTO.getNumberLccn();
        if ( list5 != null ) {
            bookEntity.setNumberLccn( new ArrayList<String>( list5 ) );
        }
        List<String> list6 = bookDTO.getNumberOclc();
        if ( list6 != null ) {
            bookEntity.setNumberOclc( new ArrayList<String>( list6 ) );
        }
        List<String> list7 = bookDTO.getOnlineFormat();
        if ( list7 != null ) {
            bookEntity.setOnlineFormat( new ArrayList<String>( list7 ) );
        }
        List<String> list8 = bookDTO.getImageUrl();
        if ( list8 != null ) {
            bookEntity.setImageUrl( new ArrayList<String>( list8 ) );
        }
        List<String> list9 = bookDTO.getPartof();
        if ( list9 != null ) {
            bookEntity.setPartof( new ArrayList<String>( list9 ) );
        }
        bookEntity.setItem( itemMapper.toEntity( bookDTO.getItem() ) );
        bookEntity.setResources( resourceDTOListToResourceEntityList( bookDTO.getResources() ) );
        bookEntity.setSegments( segmentDTOListToSegmentEntityList( bookDTO.getSegments() ) );

        return bookEntity;
    }

    protected ResourceDTO resourceEntityToResourceDTO(ResourceEntity resourceEntity) {
        if ( resourceEntity == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setId( resourceEntity.getId() );
        resourceDTO.setDjvuTextFile( resourceEntity.getDjvuTextFile() );
        resourceDTO.setFulltextDerivative( resourceEntity.getFulltextDerivative() );
        resourceDTO.setFulltextFile( resourceEntity.getFulltextFile() );
        resourceDTO.setImage( resourceEntity.getImage() );
        resourceDTO.setPaprikaResourcePath( resourceEntity.getPaprikaResourcePath() );
        resourceDTO.setPdf( resourceEntity.getPdf() );
        resourceDTO.setSearch( resourceEntity.getSearch() );
        resourceDTO.setUrl( resourceEntity.getUrl() );
        resourceDTO.setRepresentativeIndex( resourceEntity.getRepresentativeIndex() );
        resourceDTO.setVersion( resourceEntity.getVersion() );
        resourceDTO.setSegments( resourceEntity.getSegments() );
        resourceDTO.setFiles( resourceEntity.getFiles() );

        return resourceDTO;
    }

    protected List<ResourceDTO> resourceEntityListToResourceDTOList(List<ResourceEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ResourceDTO> list1 = new ArrayList<ResourceDTO>( list.size() );
        for ( ResourceEntity resourceEntity : list ) {
            list1.add( resourceEntityToResourceDTO( resourceEntity ) );
        }

        return list1;
    }

    protected SegmentDTO segmentEntityToSegmentDTO(SegmentEntity segmentEntity) {
        if ( segmentEntity == null ) {
            return null;
        }

        SegmentDTO segmentDTO = new SegmentDTO();

        segmentDTO.setId( segmentEntity.getId() );
        segmentDTO.setUrl( segmentEntity.getUrl() );
        segmentDTO.setCount( segmentEntity.getCount() );
        segmentDTO.setLink( segmentEntity.getLink() );

        return segmentDTO;
    }

    protected List<SegmentDTO> segmentEntityListToSegmentDTOList(List<SegmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SegmentDTO> list1 = new ArrayList<SegmentDTO>( list.size() );
        for ( SegmentEntity segmentEntity : list ) {
            list1.add( segmentEntityToSegmentDTO( segmentEntity ) );
        }

        return list1;
    }

    protected ResourceEntity resourceDTOToResourceEntity(ResourceDTO resourceDTO) {
        if ( resourceDTO == null ) {
            return null;
        }

        ResourceEntity resourceEntity = new ResourceEntity();

        resourceEntity.setId( resourceDTO.getId() );
        resourceEntity.setDjvuTextFile( resourceDTO.getDjvuTextFile() );
        resourceEntity.setFulltextDerivative( resourceDTO.getFulltextDerivative() );
        resourceEntity.setFulltextFile( resourceDTO.getFulltextFile() );
        resourceEntity.setImage( resourceDTO.getImage() );
        resourceEntity.setPaprikaResourcePath( resourceDTO.getPaprikaResourcePath() );
        resourceEntity.setPdf( resourceDTO.getPdf() );
        resourceEntity.setSearch( resourceDTO.getSearch() );
        resourceEntity.setUrl( resourceDTO.getUrl() );
        resourceEntity.setFiles( resourceDTO.getFiles() );
        resourceEntity.setRepresentativeIndex( resourceDTO.getRepresentativeIndex() );
        resourceEntity.setSegments( resourceDTO.getSegments() );
        resourceEntity.setVersion( resourceDTO.getVersion() );

        return resourceEntity;
    }

    protected List<ResourceEntity> resourceDTOListToResourceEntityList(List<ResourceDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ResourceEntity> list1 = new ArrayList<ResourceEntity>( list.size() );
        for ( ResourceDTO resourceDTO : list ) {
            list1.add( resourceDTOToResourceEntity( resourceDTO ) );
        }

        return list1;
    }

    protected SegmentEntity segmentDTOToSegmentEntity(SegmentDTO segmentDTO) {
        if ( segmentDTO == null ) {
            return null;
        }

        SegmentEntity segmentEntity = new SegmentEntity();

        segmentEntity.setId( segmentDTO.getId() );
        segmentEntity.setUrl( segmentDTO.getUrl() );
        segmentEntity.setCount( segmentDTO.getCount() );
        segmentEntity.setLink( segmentDTO.getLink() );

        return segmentEntity;
    }

    protected List<SegmentEntity> segmentDTOListToSegmentEntityList(List<SegmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SegmentEntity> list1 = new ArrayList<SegmentEntity>( list.size() );
        for ( SegmentDTO segmentDTO : list ) {
            list1.add( segmentDTOToSegmentEntity( segmentDTO ) );
        }

        return list1;
    }
}
