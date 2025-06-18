package cz.dipcom.simulator.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SegmentDTO {
    private Long id;
    @NotNull
    private String url;
    @NotNull
    private Integer count;
    @NotNull
    private String link;
}

