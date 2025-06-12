package cz.dipcom.simulator.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @NotNull
    private Long id;
    @NotNull
    private Boolean access_restricted;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Boolean digitized;
    @NotNull
    private LocalDateTime date;
    @NotNull
    private String language;
    @NotNull
    private String type;
    @NotNull
    private String url;

    @NotNull
    private List<String> aka;
    @NotNull
    private List<String> contributors;
    @NotNull
    private List<String> campaigns;
    @NotNull
    private List<String> imageUrls;
    @NotNull
    private List<String> mimeTypes;
    @NotNull
    private List<String> onlineFormats;
    @NotNull
    private List<String> originalFormats;
    @NotNull
    private List<String> otherTitles;
    @NotNull
    private List<String> partOfCollections;
    @NotNull
    private List<String> sites;

    private ItemDTO item;
    private List<ResourceDTO> resources;
    private List<SegmentDTO> segments;

}
