package com.voting.service;

import com.voting.models.ElectionData;
import com.voting.repository.ElectionRepository;
import com.voting.service.interfaces.ElectionService;
import com.voting.view.ElectionView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectionServiceImpl implements ElectionService {
    private final ElectionRepository electionRepository;

    @Override
    public List<ElectionView> getElectionsView(String status) {
        return electionRepository.findAllByStatus(status);
    }

    @Override
    public  Optional<ElectionData> getElectionById(Long id) {
        return electionRepository.findById(id);
    }

    @Override
    public Optional<ElectionView> getElectionByCode(String code) {
        return electionRepository.findByCode(code);
    }

    @Override
    public ElectionData saveElection(ElectionData electionCommand) {
        return electionRepository.save(electionCommand);
    }

    @Override
    public void deleteById(Long idToDelete) {
        electionRepository.deleteById(idToDelete);
    }
}
