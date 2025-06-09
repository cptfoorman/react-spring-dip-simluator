package cz.dipcom.simulator.entity;

import jakarta.persistence.*;


@Entity(name = "segment")
public class SegmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private BookEntity book;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private Integer count;
    @Column(nullable = false)
    private String link;

        // Getters and setters
}
