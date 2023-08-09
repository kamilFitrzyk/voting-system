package com.voting.view;


import com.voting.models.ElectionData;
import lombok.Getter;

@Getter
public class ElectionView {
    private Long id;
    private String name;

    public void fill(ElectionData electionData) {
        id = electionData.getId();
        name = electionData.getName();
    }

}
