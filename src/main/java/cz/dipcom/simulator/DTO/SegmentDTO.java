package cz.dipcom.simulator.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentDTO {
    private Long id;
    @Nullable
    private String url;
    @Nullable
    private Integer count;
    @Nullable
    private String link;
}

