package cz.dipcom.simulator.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    private Long id;
    @NotNull
    private String djvuTextFile;
    @NotNull
    private String fulltextDerivative;
    @NotNull
    private String fulltextFile;
    @NotNull
    private String image;
    @NotNull
    private String paprikaResourcePath;
    @NotNull
    private String pdf;
    @NotNull
    private String search;
    @NotNull
    private String url;
    @NotNull
    private int representativeIndex;
    @NotNull
    private int version;
    @NotNull
    private int segments;
    @NotNull
    private int files;


}

