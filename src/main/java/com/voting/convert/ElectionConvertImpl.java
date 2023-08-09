package com.voting.convert;

import com.voting.command.ElectionCommand;
import com.voting.models.ElectionData;
import com.voting.convert.interfaces.ElectionConvert;
import org.springframework.stereotype.Service;

@Service
public class ElectionConvertImpl implements ElectionConvert {

    @Override
    public ElectionData convertToElectionData(ElectionCommand electionCommand) {
        ElectionData election = new ElectionData();
        election.setName(electionCommand.getName());
        election.setStatus(electionCommand.getStatus());
        return election;
    }
}
