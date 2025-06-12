package cz.dipcom.simulator.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    @NotNull
    private String url;
    @NotNull
    private String pdfUrl;
    @NotNull
    private String djvuTextFile;
    @NotNull
    private String fullTextFile;
    @NotNull
    private String fullTextDerivative;
    @NotNull
    private String imageUrl;
    @NotNull
    private String paprikaResourcePath;
    @NotNull
    private Integer files;
    @NotNull
    private Integer segments;
}

