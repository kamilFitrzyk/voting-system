package com.voting.controller;

import com.voting.command.ElectionCommand;
import com.voting.models.ElectionData;
import com.voting.service.interfaces.ElectionService;
import com.voting.view.ElectionView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
public class ElectionController {

    private final ElectionService electionService;

    @GetMapping("/{id}")
    public ResponseEntity<ElectionView> getElection(@PathVariable Long id) {
        Optional<ElectionData> election = electionService.getElectionById(id);
        if (election.isPresent()) {
            ElectionView electionView = new ElectionView();
            electionView.fill(election.get());
            return ResponseEntity.ok(electionView);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ElectionData> createUser(@RequestBody ElectionCommand electionCommand) {
        ElectionData electionData = electionService.saveElection(electionCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(electionData);
    }


}
