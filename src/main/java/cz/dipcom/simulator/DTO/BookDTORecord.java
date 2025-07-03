package cz.dipcom.simulator.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;

import java.util.List;

public record BookDTORecord(
        @JsonProperty(value = "numericId")
        Long idNum,

        @Nullable
        Integer index,
        @Nullable
        @JsonProperty("title")
        String title,
        @Nullable
        @JsonProperty("type")

        String type,
        @Nullable
        @JsonProperty("url")
        String url,
        @Nullable
        @JsonProperty("shelf_id")
        String shelfId,

        @Nullable
        @JsonProperty("id")
        String urlId,
        @Nullable
        @JsonProperty("access_restricted")
        boolean accessRestricted,
        @Nullable
        @JsonProperty("digitized")
        boolean digitized,
        @Nullable
        @JsonProperty("has_segments")
        boolean hasSegments,
        @JsonProperty("date")
        Integer date,
        @JsonProperty("extract_timestamp")
        String extractTimestamp,
        @JsonProperty("timestamp")
        String timestamp,

        @Nullable
        @JsonProperty("aka")
        List<String> aka,
        @Nullable
        @JsonProperty("contributors")
        List<String> contributors,
        @Nullable
        @JsonProperty("language")
        List<String> language,
        @Nullable
        @JsonProperty("mime_type")
        List<String> mimeType,
        @Nullable
        @JsonProperty("number")
        List<String> number,
        @Nullable
        @JsonProperty("number_lccn")
        List<String> numberLccn,
        @Nullable
        @JsonProperty("number_oclc")
        List<String> numberOclc,
        @Nullable
        @JsonProperty("online_format")
        List<String> onlineFormat,
        @Nullable
        @JsonProperty("image_url")
        List<String> imageUrl,
        @Nullable
        @JsonProperty("partof")
        List<String> partof,

        ItemDTO item,
        List<ResourceDTO> resources,
        List<SegmentDTO> segments
        ) {
}
