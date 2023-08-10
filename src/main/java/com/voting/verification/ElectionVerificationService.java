package com.voting.verification;

import com.voting.command.ElectionCommand;
import com.voting.models.ElectionData;
import org.springframework.stereotype.Service;

@Service
public class ElectionVerificationService {
    public void fillInformation(ElectionCommand command, ElectionData electionData) {
        electionData.setName(command.getName());
        electionData.setCode(command.getCode());
        electionData.setStatus(command.getStatus());

    }
}
