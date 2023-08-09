package com.voting.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "elections")
@Getter
@Setter
public class ElectionData  {

    @UtilityClass
    class Status {
        static String BEFORE_ELECTION = "B";
        static String AFTER_ELECTION = "A";
        static String DURING_ELECTION = "D";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ELE_ID")
    private Long id;

    @Column(name = "ELE_NAME")
    private String name;

    @Column(name = "ELE_STATUS")
    private char status;

    @OneToMany(mappedBy = "electionData", orphanRemoval = true)
    private Set<QuestionData> questions = new HashSet<>();

}
