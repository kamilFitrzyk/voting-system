package com.voting.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ElectionCommand {
    private String name;
    private char status;
}
