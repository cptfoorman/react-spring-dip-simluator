package cz.dipcom.simulator.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BookEntity {
    @Id
    private Long id;
    @Column(nullable = false)
    private Boolean access_restricted;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean digitized;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String url;

    @ElementCollection
    private List<String> aka;

    @ElementCollection
    private List<String> contributors;

    @ElementCollection
    private List<String> campaigns;

    @ElementCollection
    private List<String> imageUrls;

    @ElementCollection
    private List<String> mimeTypes;

    @ElementCollection
    private List<String> onlineFormats;

    @ElementCollection
    private List<String> originalFormats;

    @ElementCollection
    private List<String> otherTitles;

    @ElementCollection
    private List<String> partOfCollections;

    @ElementCollection
    private List<String> sites;

    @OneToOne(cascade = CascadeType.ALL)
    private ItemEntity item;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResourceEntity> resources;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SegmentEntity> segments;

}
