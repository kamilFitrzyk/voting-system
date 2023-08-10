package com.voting.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class QuestionData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "QUE_ID", nullable = false)
    private Long id;

    @Column(name = "QUE_QUESTION")
    private String question;

    @ManyToOne
    @JoinColumn(name = "election_data_ele_id")
    private ElectionData electionData;

}
