package cz.dipcom.simulator.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String callNumber;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String createdPublished;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String format;
    @Column(nullable = false)
    private String medium;
    @Column(nullable = false)
    private String language;

    @ElementCollection
    private List<String> notes;
}
