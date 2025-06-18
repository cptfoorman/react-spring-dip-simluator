package cz.dipcom.simulator.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ItemDTO {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @JsonProperty("created_published")
    private List<String> createdPublished;

    @NotNull
    @JsonProperty("call_number")
    private List<String> callNumber;
    @NotNull
    private List<String> contributors;
    @NotNull
    private List<String> format;
    @NotNull
    private List<String> language;
    @NotNull
    private List<String> medium;
    @NotNull
    private List<String> notes;


}
