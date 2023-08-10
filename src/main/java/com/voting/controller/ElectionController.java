package com.voting.controller;

import com.voting.command.CommandProcessor;
import com.voting.command.ElectionCommand;
import com.voting.exception.ApplicationException;
import com.voting.models.ElectionData;
import com.voting.service.interfaces.ElectionService;
import com.voting.view.ElectionView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
public class ElectionController {

    private final ElectionService electionService;

    private final CommandProcessor commandProcessor;

    @GetMapping("/{code}")
    public ResponseEntity<ElectionView> getElection(@PathVariable String code) {
        Optional<ElectionView> election = electionService.getElectionByCode(code);
        return election.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ElectionView>> getElections() {
        List<ElectionView> election = electionService.getElectionsView("D");
        if (!election.isEmpty()) {
            return ResponseEntity.ok(election);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ElectionData> createUser(@RequestBody ElectionCommand electionCommand) throws ApplicationException {
        commandProcessor.process(electionCommand);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").build().expand(electionCommand.getName()).toUri()).build();
    }


}
