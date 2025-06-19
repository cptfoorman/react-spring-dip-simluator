package cz.dipcom.simulator.repository.filters;

import lombok.Data;

import java.time.LocalDateTime;

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
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private int limit;

}
