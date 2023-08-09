package com.voting.convert.interfaces;

import com.voting.command.ElectionCommand;
import com.voting.models.ElectionData;

public interface ElectionConvert {
    ElectionData convertToElectionData(ElectionCommand electionCommand);
}
