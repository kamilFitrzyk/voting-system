package com.voting.handlers;

import com.voting.command.CommandHandler;
import com.voting.command.ElectionCommand;
import com.voting.exception.ApplicationException;
import com.voting.models.ElectionData;
import com.voting.service.interfaces.ElectionService;
import com.voting.validator.ElectionValidator;
import com.voting.verification.ElectionVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateElectionCommandHandler implements CommandHandler<ElectionCommand, Void> {

    private final ElectionService electionService;

    private final ElectionValidator electionValidator;

    private final ElectionVerificationService electionVerificationService;

    @Override
    public Void execute(ElectionCommand command) throws ApplicationException {
        ElectionData electionData = new ElectionData();
        electionVerificationService.fillInformation(command, electionData);
        electionValidator.validateCreation(electionData);
        electionService.saveElection(electionData);
        return null;
    }
}
