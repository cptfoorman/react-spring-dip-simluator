package cz.dipcom.simulator.DTO;

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
    @NotNull
    private String callNumber;
    @NotNull
    private String title;
    @NotNull
    private String createdPublished;
    @NotNull
    @Positive
    private LocalDateTime date;
    @NotNull
    private String format;
    @NotNull
    private String medium;
    @NotNull
    private String language;
    @NotNull
    private List<String> notes;

}
