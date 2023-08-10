package com.voting.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "elections")
@Getter
@Setter
public class ElectionData  {

    @UtilityClass
    public class Status {
        public static final String BEFORE_ELECTION = "B";
        public static final String AFTER_ELECTION = "A";
        public static final String DURING_ELECTION = "D";
    }

    protected static final Set<String> AVAILABLE_STATUS = new HashSet<>(Arrays.asList(
        Status.AFTER_ELECTION,
        Status.DURING_ELECTION,
        Status.BEFORE_ELECTION
    ));


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ELE_ID")
    private Long id;

    @Column(name = "ELE_CODE")
    private String code;

    @Column(name = "ELE_NAME")
    private String name;

    @Column(name = "ELE_STATUS")
    private String status;

    @OneToMany(mappedBy = "electionData", orphanRemoval = true)
    private Set<QuestionData> questions = new HashSet<>();

}
