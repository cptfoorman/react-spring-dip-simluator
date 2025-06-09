package cz.dipcom.simulator.entity;

import jakarta.persistence.*;

@Entity
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private BookEntity book;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String pdfUrl;
    @Column(nullable = false)
    private String djvuTextFile;
    @Column(nullable = false)
    private String fullTextFile;
    @Column(nullable = false)
    private String fullTextDerivative;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private String paprikaResourcePath;
    @Column(nullable = false)
    private Integer files;
    @Column(nullable = false)
    private Integer segments;

        // Getters and setters
}
