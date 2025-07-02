package cz.dipcom.simulator.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceDTO {
    private Long id;
    @Nullable
    @JsonProperty("djvu_text_file")
    private String djvuTextFile;
    @Nullable
    @JsonProperty("fulltext_derivative")
    private String fulltextDerivative;
    @Nullable
    @JsonProperty("fulltext_file")
    private String fulltextFile;
    @Nullable
    private String image;
    @Nullable
    @JsonProperty("paprika_resource_path")
    private String paprikaResourcePath;
    @Nullable
    private String pdf;
    @Nullable
    private String search;
    @Nullable
    private String url;
    @Nullable
    @JsonProperty("representative_index")
    private int representativeIndex;
    @Nullable
    private int version;
    @Nullable
    private int segments;
    @Nullable
    private int files;

}

