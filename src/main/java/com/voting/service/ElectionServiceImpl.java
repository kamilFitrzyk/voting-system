package com.voting.service;

import com.voting.command.ElectionCommand;
import com.voting.models.ElectionData;
import com.voting.repository.ElectionRepository;
import com.voting.service.interfaces.ElectionService;
import com.voting.convert.interfaces.ElectionConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectionServiceImpl implements ElectionService {

    private final ElectionConvert electionConvert;
    private final ElectionRepository electionRepository;

    @Override
    public List<ElectionData> getElections() {
        return electionRepository.findAll();
    }

    @Override
    public  Optional<ElectionData> getElectionById(Long id) {
        return electionRepository.findById(id);
    }

    @Override
    public ElectionData saveElection(ElectionCommand electionCommand) {
        return electionRepository.save(electionConvert.convertToElectionData(electionCommand));
    }

    @Override
    public void deleteById(Long idToDelete) {
        electionRepository.deleteById(idToDelete);
    }
}
