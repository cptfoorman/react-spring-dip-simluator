package cz.dipcom.simulator.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class ItemEntity {
    @Id
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

    // Getters and setters
}
