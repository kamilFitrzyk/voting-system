package com.voting.service;

import com.voting.models.Vote;
import com.voting.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public Optional<Vote> getAll() {
        return voteRepository.findById(10L);
    }

    public void save(Vote vote) {
        voteRepository.save(vote);
    }

}
