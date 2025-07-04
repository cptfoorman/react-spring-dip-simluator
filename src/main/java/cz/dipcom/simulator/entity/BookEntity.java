package cz.dipcom.simulator.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;


/**
 * Entity class that is actually saved in the database
 * nothing too much of note,
 * I used element collections for the arrays of values the base JSON has
 * and I used OffsetDateTime for dates since it parses way easier than LocalDateTime
 */
@Getter
@Setter
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNum;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String shelfId;

    @Column(nullable = false)
    private boolean accessRestricted;
    @Column(nullable = false)
    private boolean digitized;
    @Column(nullable = false)
    private boolean hasSegments;
    @Column(nullable = false)
    private String urlId;

    @Column(nullable = false)
    private Integer index;
    @Column(nullable = false)
    private Integer date;
    @Column(nullable = false)
    private OffsetDateTime extractTimestamp;
    @Column(nullable = false)
    private OffsetDateTime timestamp;

    @ElementCollection
    private List<String> aka;

    @ElementCollection
    private List<String> contributors;

    @ElementCollection
    private List<String> language;

    @ElementCollection
    private List<String> mimeType;

    @ElementCollection
    private List<String> number;

    @ElementCollection
    private List<String> numberLccn;


    @ElementCollection
    private List<String> numberOclc;

    @ElementCollection
    private List<String> onlineFormat;

    @ElementCollection
    private List<String> imageUrl;


    @ElementCollection
    private List<String> partof;


    @OneToOne(cascade = CascadeType.ALL)
    private ItemEntity item;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResourceEntity> resources;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SegmentEntity> segments;

}
