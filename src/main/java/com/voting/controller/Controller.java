package com.voting.controller;

import com.voting.models.Vote;
import com.voting.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final VoteService voteService;
    @GetMapping("/test")
    public String test() {


        Optional<Vote> all = voteService.getAll();
        return "test";
    }
}
