package com.voting.service.interfaces;

import com.voting.command.ElectionCommand;
import com.voting.models.ElectionData;

import java.util.List;
import java.util.Optional;

public interface ElectionService {

    List<ElectionData> getElections();

    Optional<ElectionData> getElectionById(Long id);

    ElectionData saveElection(ElectionCommand election);

    void deleteById(Long idToDelete);
}
