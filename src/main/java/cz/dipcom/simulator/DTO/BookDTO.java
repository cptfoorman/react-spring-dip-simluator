package cz.dipcom.simulator.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "numericId")
    private Long idNum;
    @Nullable
    @JsonProperty("title")
    private String title;
    @Nullable
    @JsonProperty("type")
    private String type;
    @Nullable
    @JsonProperty("url")
    private String url;
    @Nullable
    @JsonProperty("shelf_id")
    private String shelfId;

    @Nullable
    @JsonProperty("id")
    private String urlId;
    @Nullable
    @JsonProperty("access_restricted")
    private boolean accessRestricted;
    @Nullable
    @JsonProperty("digitized")
    private boolean digitized;
    @Nullable
    @JsonProperty("has_segments")
    private boolean hasSegments;

    @JsonProperty("date")
    private String date;
    @JsonProperty("extract_timestamp")
    private String  extractTimestamp;
    @JsonProperty("timestamp")
    private String  timestamp;

    @Nullable
    @JsonProperty("aka")
    private List<String> aka;
    @Nullable
    @JsonProperty("contributors")
    private List<String> contributors;
    @Nullable
    @JsonProperty("language")
    private List<String> language;
    @Nullable
    @JsonProperty("mime_type")
    private List<String> mimeType;
    @Nullable
    @JsonProperty("number")
    private List<String> number;
    @Nullable
    @JsonProperty("number_lccn")
    private List<String> numberLccn;
    @Nullable
    @JsonProperty("number_oclc")
    private List<String> numberOclc;
    @Nullable
    @JsonProperty("online_format")
    private List<String> onlineFormat;
    @Nullable
    @JsonProperty("image_url")
    private List<String> imageUrl;
    @Nullable
    @JsonProperty("partof")
    private List<String> partof;

    private ItemDTO item;
    private List<ResourceDTO> resources;
    private List<SegmentDTO> segments;


}
