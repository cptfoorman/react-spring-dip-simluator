package cz.dipcom.simulator.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @JsonProperty("numericId")
    private Long idNum;
    @NotNull
    private String title;
    @NotNull
    private String type;
    @NotNull
    private String url;
    @NotNull
    private String shelfId;

    @NotNull
    @JsonProperty("id")
    private String urlId;
    @NotNull
    private boolean accessRestricted;
    @NotNull
    private boolean digitized;
    @NotNull
    private boolean hasSegments;

    private String date;
    private String  extractTimestamp;
    private String  timestamp;

    @NotNull
    private List<String> aka;
    @NotNull
    private List<String> contributors;
    @NotNull
    private List<String> language;
    @NotNull
    private List<String> mimeType;
    @NotNull
    private List<String> number;
    @NotNull
    private List<String> numberLccn;
    @NotNull
    private List<String> numberOclc;
    @NotNull
    private List<String> onlineFormat;
    @NotNull
    private List<String> imageUrl;
    @NotNull
    private List<String> partof;

    private ItemDTO item;
    private List<ResourceDTO> resources;
    private List<SegmentDTO> segments;


}
