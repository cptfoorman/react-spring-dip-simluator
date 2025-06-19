package cz.dipcom.simulator.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDTO {
    private Long id;
    @Nullable
    private String title;
    @Nullable
    @JsonProperty("created_published")
    private List<String> createdPublished;

    @Nullable
    @JsonProperty("call_number")
    private List<String> callNumber;
    @Nullable
    private List<String> contributors;
    @Nullable
    private List<String> format;
    @Nullable
    private List<String> language;
    @Nullable
    private List<String> medium;
    @Nullable
    private List<String> notes;


}
