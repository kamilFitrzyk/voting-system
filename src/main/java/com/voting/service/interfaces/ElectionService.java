package com.voting.service.interfaces;

import com.voting.models.ElectionData;
import com.voting.view.ElectionView;

import java.util.List;
import java.util.Optional;

public interface ElectionService {

    List<ElectionView> getElectionsView(String status);

    Optional<ElectionData> getElectionById(Long id);

    Optional<ElectionView> getElectionByCode(String code);

    ElectionData saveElection(ElectionData election);

    void deleteById(Long idToDelete);
}
