package cz.dipcom.simulator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity class that is actually saved in the database
 * nothing too much of note,
 * I used element collections for the arrays of values the base JSON has
 */
@Getter
@Setter
@Entity(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @ElementCollection
    private List<String> createdPublished;

    @ElementCollection
    private List<String> callNumber;

    @ElementCollection
    private List<String> contributors;

    @ElementCollection
    private List<String> format;

    @ElementCollection
    private List<String> language;

    @ElementCollection
    private List<String> medium;

    @ElementCollection
    private List<String> notes;

}
