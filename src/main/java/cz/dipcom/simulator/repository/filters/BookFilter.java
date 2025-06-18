package cz.dipcom.simulator.repository.filters;

import lombok.Data;

import java.time.LocalDateTime;

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
