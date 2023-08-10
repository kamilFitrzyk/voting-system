package com.voting.validator;

import com.voting.config.ConfigError;
import com.voting.exception.ApplicationException;
import com.voting.models.ElectionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ElectionValidator {

    public void validateCreation(ElectionData electionToValidate) throws ApplicationException {

        validStatus(electionToValidate);
    }

    private void validStatus(ElectionData electionToValidate) throws ApplicationException {
        if (!ElectionData.Status.AFTER_ELECTION.equals(electionToValidate.getStatus())) {
            throw new ApplicationException(ConfigError.ELECTION_STATUS_NOT_FOUND);
        }


    }
}
