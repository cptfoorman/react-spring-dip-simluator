package cz.dipcom.simulator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "resource")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String djvuTextFile;
    @Column(nullable = false)
    private String fulltextDerivative;
    @Column(nullable = false)
    private String fulltextFile;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String paprikaResourcePath;
    @Column(nullable = false)
    private String pdf;
    @Column(nullable = false)
    private String search;
    @Column(nullable = false)
    private String url;


    @Column(nullable = false)
    private int files;
    @Column(nullable = false)
    private int representativeIndex;
    @Column(nullable = false)
    private int segments;
    @Column(nullable = false)
    private int version;

}
