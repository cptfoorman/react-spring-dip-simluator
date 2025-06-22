package cz.dipcom.simulator.repository.filters;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Filter Object for querries,
 * made it into an object to encapsulate the parameters
 */
@Data
public class BookFilter {
    private String title;
    private String type;
    private String language;
    private Boolean accessRestricted;
    private String mimeType;
    private String urlId;
    private String shelfId;
    private Integer index;
    private Integer yearFrom;
    private Integer yearTo;
    private Integer limit = 10;
    private int page = 0;

}
